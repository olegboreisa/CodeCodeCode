package lt.boreisa.finalblog.Model;

import lombok.Data;
import lt.boreisa.finalblog.Validation.PasswordMatches;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
@PasswordMatches
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date")
    @CreationTimestamp
    private LocalDate registrationDate;

    @Length(min = 3, message = "{nickname.error}")
    @Column(name = "nickname")
    private String nickName;

    @NotNull
    @NotEmpty
    @Column(name = "password")
    private String password;
    @Column(name = "matchPassword")
    private String matchPassword;

    @NotEmpty
    @Column(name = "country")
    private String country;

    @NotEmpty
    @Column(name = "phone_number")
    private String phoneNum;

    @ManyToMany
    @Column(name = "role")
    private Set<Role> role;
}
