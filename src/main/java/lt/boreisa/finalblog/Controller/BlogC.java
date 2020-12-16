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
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    /** Main Page */
    @RequestMapping(path = {"", "/", "main"}, method = RequestMethod.GET)
    public String getMain () {
        return "blog/index";
    }

    /** Delete a blog */
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBlog (@PathVariable Long id) {
        blogRepo.deleteById(id);
        commentRepo.customDeleteAllById(id);
        return "redirect:/get-list/" + id;
    }
    /** Paginated List */
    @GetMapping("/get-list")
    public String getPaginatedList (Model model) {
        return findPaginated(1, model);
    }
    @GetMapping("/get-list/{pageNo}")
    public String findPaginated (@PathVariable (value = "pageNo") int pageNom, Model model) {
        // [HOW MANY ELEMENTS ON THE PAGE. CAN BE DECLARED IN UI]
        int pageSize = 1;
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
        //TODO: TRYING TO DO A PAGINATED CUSTOM COMMENTS
        Pageable pageableC = PageRequest.of(0, 50);
        //TODO: IF I DELETE A BLOG pageNom ALWAYS NUSIMUŠA IR TADA KOMENTARAS PRIKLAUSO JAU KITAM ĮRAŠUI
        //WARN: Added neededId. Maybe other option?!
        Page<Comment> pageC = commentRepo.findAllCustomComments(neededId, pageableC);
        List<Comment> pageCom = pageC.getContent();
        model.addAttribute("comList", pageCom);

        return "blog/blog-list";
    }

    /** Add a blog
     * Get Empty Blog Model
     * */
    @RequestMapping(path = "/add-blog", method = RequestMethod.GET)
    public String addBlog (@ModelAttribute (name = "newBlog") Blog blog) {
        return "blog/blog-add";
    }

    @RequestMapping(path = "/add-new-blog", method = RequestMethod.POST)
    public String addedBlog(@Valid @ModelAttribute (name = "newBlog") Blog blog, BindingResult bindingResult, @Param("action") String action) {
        if (bindingResult.hasErrors() && action.equals("submit")) {
            log.info("[NOT ADDED]: {}", blog);
            return "blog/blog-add";
        } else if (!bindingResult.hasErrors() && action.equals("submit")) {
            blogRepo.save(blog);
            return "redirect:/get-list";
        } else if (bindingResult.hasErrors() && action.equals("return")) {
            return "redirect:/main";
        }
        return null;
    }
}
