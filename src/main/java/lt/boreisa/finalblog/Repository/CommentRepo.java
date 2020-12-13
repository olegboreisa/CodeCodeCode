package lt.boreisa.finalblog.Repository;

import lt.boreisa.finalblog.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;
import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface CommentRepo extends JpaRepository <Comment, Long> {

    @Query(
            value = "SELECT * FROM comment WHERE blog_id = ?1",
            nativeQuery = true
            )
    List<Comment> findAllRelatedBlogById(int id);

    @Query(
            value = "SELECT * FROM comment WHERE name = ?1",
            nativeQuery = true
    )
    Comment findWhoCommented(String name);
}
