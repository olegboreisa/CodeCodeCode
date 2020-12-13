package lt.boreisa.finalblog.Controller;

import lombok.extern.slf4j.Slf4j;
import lt.boreisa.finalblog.Model.Comment;
import lt.boreisa.finalblog.Repository.CommentRepo;
import lt.boreisa.finalblog.Service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
public class CommentC {

    private final CommentRepo commentRepo;
    private final CommentService commentService;

    public CommentC(CommentRepo commentRepo, CommentService commentService) {
        this.commentRepo = commentRepo;
        this.commentService = commentService;
    }

//    @GetMapping("/get-list")
//    public String getPaginatedCommentList (Model model) {
//        return findPaginatedCommentList(1, model);
//    }
//
//    @GetMapping("/get-list/{pageNo}")
//    public String findPaginatedCommentList (@PathVariable (value = "pageNo") int pageNo, Model model) {
//
//        int pageSize = 1;
//        Page<Comment> page = commentService.findPaginatedCustomComment(pageNo, pageNo, pageSize);
//        List<Comment> commentList = page.getContent();
//
//        model.addAttribute("currentPage", pageNo);
//        log.info("pageNo{}", pageNo);
//        model.addAttribute("totalPages", page.getTotalPages());
//        log.info("totalPages {}", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//        log.info("totalItems {}", page.getTotalElements());
//        model.addAttribute("listCustomComment", commentList);
//        log.info("Comment List {}", commentList);
//
//
//        return "blog/blog-list";
//    }
}
