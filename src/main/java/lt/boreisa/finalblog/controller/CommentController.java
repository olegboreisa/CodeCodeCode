package lt.boreisa.finalblog.controller;

import lombok.extern.slf4j.Slf4j;
import lt.boreisa.finalblog.model.Comment;
import lt.boreisa.finalblog.repository.CommentRepo;
import lt.boreisa.finalblog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class CommentController {

    private final CommentRepo commentRepo;
    private final CommentService commentService;

    public CommentController(CommentRepo commentRepo, CommentService commentService) {
        this.commentRepo = commentRepo;
        this.commentService = commentService;
    }

    @RequestMapping(path = "/add-comment", method = RequestMethod.GET)
    public String addComment (@ModelAttribute ("newComment") Comment comment) {
        return "";
    }
}
