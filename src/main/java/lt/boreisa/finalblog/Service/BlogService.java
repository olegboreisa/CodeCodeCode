package lt.boreisa.finalblog.Service;

import lt.boreisa.finalblog.Model.Blog;
import lt.boreisa.finalblog.Repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final BlogRepo blogRepo;

    @Autowired
    public BlogService(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    //[SINCE PageRequest is 0 BASED (FOR USER IT STARTS FROM 1, WE HAVE TO DO -1]
    //THIS METHOD ALLOWS US TO DO PAGINATION!
    //Pageable is an interface, PageRequest is a class that implements Pageable!
    public Page<Blog> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.blogRepo.findAll(pageable);
    }
}
