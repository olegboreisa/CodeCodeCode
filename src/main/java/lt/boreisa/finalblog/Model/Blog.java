package lt.boreisa.finalblog.Model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


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
}
