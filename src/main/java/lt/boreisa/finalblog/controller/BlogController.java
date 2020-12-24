package lt.boreisa.finalblog.controller;

import lombok.extern.slf4j.Slf4j;
import lt.boreisa.finalblog.model.Blog;
import lt.boreisa.finalblog.model.Comment;
import lt.boreisa.finalblog.repository.BlogRepo;
import lt.boreisa.finalblog.repository.CommentRepo;
import lt.boreisa.finalblog.service.BlogService;
import lt.boreisa.finalblog.service.CommentService;
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
@RequestMapping("/private")
public class BlogController {

    // [GETTING METHODS TO EXTRACT DATA FROM DATABASE]
    private final BlogRepo blogRepo;
    private final CommentRepo commentRepo;
    private final BlogService blogService;
    private final CommentService commentService;

    @Autowired
    public BlogController(BlogRepo blogRepo, CommentRepo commentRepo, BlogService blogService, CommentService commentService) {
        this.blogRepo = blogRepo;
        this.commentRepo = commentRepo;
        this.blogService = blogService;
        this.commentService = commentService;
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

    /** Edit Blog */
    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public String editBlog (@PathVariable (name = "id") Long id, Model model) {
        Blog blog = blogRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        model.addAttribute("blogToEdit", blog);
        return "blog/blog-edit";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String editedBlog(@Valid @ModelAttribute (name = "blogToEdit") Blog blog, BindingResult bindingResult, @Param("action") String action) {
        if (bindingResult.hasErrors() && action.equals("edit")) {
            log.info("[NOT EDITE]: {}", blog);
            return "blog/blog-edit";
        }
        if (!bindingResult.hasErrors() && action.equals("edit")) {
            log.info("[EDITED]: {}", blog);
            blogRepo.save(blog);
            return "redirect:/get-list";
        }
        return "redirect:/main";
        }


    @RequestMapping(path = "/like/{id}", method = RequestMethod.GET)
    public String likeBlog (@PathVariable ("id") Long id) {
        Blog blog = blogRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id"));
        blog.setLikes(blog.getLikes() + 1);
        blogRepo.save(blog);
        return "redirect:/get-list/" + id;
    }
}
