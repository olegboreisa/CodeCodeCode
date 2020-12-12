package lt.boreisa.finalblog.Controller;

import lombok.extern.slf4j.Slf4j;
import lt.boreisa.finalblog.Model.Blog;
import lt.boreisa.finalblog.Model.Comment;
import lt.boreisa.finalblog.Repository.BlogRepo;
import lt.boreisa.finalblog.Service.BlogService;
import lt.boreisa.finalblog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@Slf4j
public class BlogC {

    // [GETTING METHODS TO EXTRACT DATA FROM DATABASE]
    private final BlogRepo blogRepo;
    private final CommentService commentService;
    private final BlogService blogService;

    @Autowired
    public BlogC(BlogRepo blogRepo, CommentService commentService, BlogService blogService) {
        this.blogRepo = blogRepo;
        this.commentService = commentService;
        this.blogService = blogService;
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
        return "redirect:/main";
    }
    @GetMapping("/get-list")
    public String getPaginatedList (Model model) {
        return findPaginated(1, model);
    }

    //TODO: Method for handling pagination [11:25]
    @GetMapping("/get-list/{pageNo}")
    public String findPaginated (@PathVariable (value = "pageNo") int pageNo, Model model) {
        int pageSize = 1; // [HOW MANY ELEMENTS ON THE PAGE. CAN BE DECLARED IN UI]

        Page<Blog> page = blogService.findPaginated(pageNo, pageSize);
        List<Blog> listBlogs = page.getContent(); // [WE GET A LIST OF BLOG OBJECTS THAT ARE PAGINATED]

        model.addAttribute("currentPage", pageNo);
        log.info("curP {}", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        log.info("totalP {}", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        log.info("totalElem {}", page.getTotalElements());
        model.addAttribute("listBlogs", listBlogs);


        return "blog/blog-list";
    }
}
