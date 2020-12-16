package lt.boreisa.finalblog.Model;

import com.sun.istack.Nullable;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @CreationTimestamp
    private LocalDate postedDate;

    @Length(min = 3, message = "{header.message}")
    @Column(name = "header")
    private String header;

    @Length(min = 10, message = "{text.message}")
    @Lob
    @Column(name = "main_text")
    private String mainText;

    @ToString.Exclude
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "blog", targetEntity = Comment.class) // [COMMENT IS HANDLING MAPPING]
//    @JoinTable(
//            name = "blog_com",
//            joinColumns = @JoinColumn(
//                    name = "blog_id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "comment_id"
//            ))
    private List<Comment> comments = new ArrayList<>();

    @Nullable
    @Column(name = "likes")
    private Long likes;
}
