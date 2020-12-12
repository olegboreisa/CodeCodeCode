package lt.boreisa.finalblog.Controller;

import lombok.extern.slf4j.Slf4j;
import lt.boreisa.finalblog.Model.Blog;
import lt.boreisa.finalblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
public class BlogC {

    // [GETTING METHODS TO EXTRACT DATA FROM DATABASE]
    private final BlogService blogService;

    @Autowired
    public BlogC(BlogService blogService) {
        this.blogService = blogService;
    }

    private Long getCount () {
        return blogService.count();
    }
    //TODO [GET MAIN]
    @RequestMapping(path = {"", "/", "main"}, method = RequestMethod.GET)
    public String getMain () {
        return "blog/index";
    }

    //TODO [GET BLOG LIST]
    @RequestMapping(path = "/get-list", method = RequestMethod.GET)
    public String getFirstOnList (Model model) {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return "/blog/blog-add";
        }
        Blog singleBlog = blogList.get(0); // [ID == 1]
        log.info("blog {}", singleBlog);
        model.addAttribute("blog", singleBlog);
        return "blog/blog-list";
    }

    //TODO: [PREVIOUS OR NEXT BLOG]
    @RequestMapping(path = "/get-list/{id}", method = RequestMethod.GET)
    public String getPreviousOrNextList (@PathVariable Long id, Model model) {
        model.addAttribute("count", getCount());
        Blog singleBlog = blogService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        model.addAttribute("blog", singleBlog);
        return "blog/blog-list";
    }

    //TODO: [DELETE BLOG]
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBlog (@PathVariable Long id) {
        blogService.deleteById(id);
        return "redirect:/main";
    }
}