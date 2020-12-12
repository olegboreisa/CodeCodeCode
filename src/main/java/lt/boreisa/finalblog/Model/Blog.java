package lt.boreisa.finalblog.Model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "posted_date")
    private LocalDate postedDate;

    @Column(name = "header")
    private String header;

    @Lob
    @Column(name = "main_text")
    private String mainText;

    @OneToMany
    @JoinTable(
            name = "blog_com",
            joinColumns = @JoinColumn(
                    name = "blog_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "comment_id"
            ))
    private List<Comment> comments = new ArrayList<>();
}
