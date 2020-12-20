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

    @Column(name = "country")
    private String country;

    @Column(name = "phone_number")
    private String phoneNum;

    @ManyToMany
    @Column(name = "role")
    private Set<Role> role;
}
