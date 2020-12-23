package lt.boreisa.finalblog.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "posted_date")
    private LocalDate postedDate;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Lob
    @Column(name = "text")
    private String text;

    @ManyToOne
    private Blog blog;

}
