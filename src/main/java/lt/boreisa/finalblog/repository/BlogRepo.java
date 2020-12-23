package lt.boreisa.finalblog.repository;

import lt.boreisa.finalblog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository <Blog, Long> {

}
