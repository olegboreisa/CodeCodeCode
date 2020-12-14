package lt.boreisa.finalblog.Controller;

import lombok.extern.slf4j.Slf4j;
import lt.boreisa.finalblog.Model.Blog;
import lt.boreisa.finalblog.Model.Comment;
import lt.boreisa.finalblog.Repository.BlogRepo;
import lt.boreisa.finalblog.Repository.CommentRepo;
import lt.boreisa.finalblog.Service.BlogService;
import lt.boreisa.finalblog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Slf4j
public class BlogC {

    // [GETTING METHODS TO EXTRACT DATA FROM DATABASE]
    private final BlogRepo blogRepo;
    private final CommentRepo commentRepo;
    private final BlogService blogService;
    private final CommentService commentService;

    @Autowired
    public BlogC(BlogRepo blogRepo, CommentRepo commentRepo, BlogService blogService, CommentService commentService) {
        this.blogRepo = blogRepo;
        this.commentRepo = commentRepo;
        this.blogService = blogService;
        this.commentService = commentService;
    }

    private Long getCount () {
        return blogRepo.count();
    }


    //TODO [GET MAIN]
    @RequestMapping(path = {"", "/", "main"}, method = RequestMethod.GET)
    public String getMain () {
        return "blog/index";
    }

//    //TODO [GET BLOG LIST]
//    @RequestMapping(path = "/get-list", method = RequestMethod.GET)
//    public String getFirstOnList (Model model) {
//        List<Blog> blogList = blogRepo.findAll();
//        if (blogList.isEmpty()) {
//            return "/blog/blog-add";
//        }
//        Blog singleBlog = blogList.get(0);// [ID == 1]
//        //TODO: EXTRACT LIST OF COMMENTS
//        List<Comment> commentList = commentService.findAll();
//        log.info("commentList {}", commentList);
//        log.info("blog {}", singleBlog);
//        model.addAttribute("blog", singleBlog);
//        return "blog/blog-list";
//    }

//    //TODO: [PREVIOUS OR NEXT BLOG]
//    @RequestMapping(path = "/get-list/{id}", method = RequestMethod.GET)
//    public String getPreviousOrNextList (@PathVariable Long id, Model model) {
//        model.addAttribute("count", getCount());
//        Blog singleBlog = blogRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
//        model.addAttribute("blog", singleBlog);
//        return "blog/blog-list";
//    }

    //TODO: [DELETE BLOG]
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBlog (@PathVariable Long id) {
        blogRepo.deleteById(id);
        commentRepo.customDeleteAllById(id);
        return "redirect:/get-list/" + id;
    }

    @GetMapping("/get-list")
    public String getPaginatedList (Model model) {
        return findPaginated(1, model);
    }

    //TODO: Method for handling pagination [11:25]
    @GetMapping("/get-list/{pageNo}")
    public String findPaginated (@PathVariable (value = "pageNo") int pageNom, Model model) {
        // [HOW MANY ELEMENTS ON THE PAGE. CAN BE DECLARED IN UI]
        int pageSize = 1;
        log.info("opop {} ", pageNom);
        Page<Blog> pageB = blogService.findPaginated(pageNom, pageSize);
        // [WE GET A LIST OF BLOG OBJECTS THAT ARE PAGINATED]
        List<Blog> listBlogs = pageB.getContent();

        model.addAttribute("currentPage", pageNom);
        model.addAttribute("totalPages", pageB.getTotalPages());
        model.addAttribute("totalItems", pageB.getTotalElements());
        model.addAttribute("blogs", listBlogs);

        Long neededId = null;
        for (Blog blog : listBlogs) {
            neededId = blog.getId();
        }
        //TODO: TRYING TO DO A PAGINATED CUSTOM COMMENT
        Pageable pageableC = PageRequest.of(0, 3);
        //TODO: IF I DELETE A BLOG pageNom ALWAYS NUSIMUŠA IR TADA KOMENTARAS PRIKLAUSO JAU KITAM ĮRAŠUI
        Page<Comment> pageC = commentRepo.findAllCustomComments(neededId, pageableC);
        List<Comment> pageCom = pageC.getContent();

        model.addAttribute("currentPage2", neededId);
        model.addAttribute("totalPages2", pageC.getTotalPages());
        model.addAttribute("totalItems2", pageC.getTotalElements());
        model.addAttribute("comList", pageCom);

        return "blog/blog-list";
    }
}
