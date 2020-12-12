package lt.boreisa.finalblog.Repository;

import lt.boreisa.finalblog.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository <Blog, Long> {
}
