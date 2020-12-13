package lt.boreisa.finalblog.Service;

import lt.boreisa.finalblog.Model.Blog;
import lt.boreisa.finalblog.Model.Comment;
import lt.boreisa.finalblog.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

//    public Page<Comment> findPaginatedCustomComments (int pageNo, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//        return this.commentRepo.findAllCustom(pageNo, pageable);
//    }
//

}


