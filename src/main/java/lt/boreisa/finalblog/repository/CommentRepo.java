package lt.boreisa.finalblog.repository;

import lt.boreisa.finalblog.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository <Comment, Long> {

    @Query(value = "SELECT * FROM comment WHERE blog_id = :blog_id ",
    nativeQuery = true)
    List<Comment> customDeleteAllById(@Param("blog_id") Long id);

    @Query(value = "SELECT * FROM comment WHERE blog_id = :blog_id",
            countQuery = "SELECT count(*) FROM comment",
            nativeQuery = true)
    Page<Comment> findAllCustomComments(@Param("blog_id") Long id, Pageable pageable);
}