package lt.boreisa.finalblog.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "password")
    private String password;

    private String country;

    private String phoneNum;

    @ManyToMany
    private Set<Role> role;
}
