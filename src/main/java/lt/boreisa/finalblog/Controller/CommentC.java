package lt.boreisa.finalblog.Controller;

import lombok.extern.slf4j.Slf4j;
import lt.boreisa.finalblog.Model.Comment;
import lt.boreisa.finalblog.Repository.CommentRepo;
import lt.boreisa.finalblog.Service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class CommentC {

    private final CommentRepo commentRepo;
    private final CommentService commentService;

    public CommentC(CommentRepo commentRepo, CommentService commentService) {
        this.commentRepo = commentRepo;
        this.commentService = commentService;
    }

    @RequestMapping(path = "/add-comment", method = RequestMethod.GET)
    public String addComment (@ModelAttribute ("newComment") Comment comment) {
        return "";
    }
}
