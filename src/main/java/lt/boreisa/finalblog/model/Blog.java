package lt.boreisa.finalblog.model;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    private User user;

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
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "blog", targetEntity = Comment.class)
    // [COMMENT IS HANDLING MAPPING]
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
