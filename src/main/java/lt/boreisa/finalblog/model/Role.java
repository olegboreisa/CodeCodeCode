package lt.boreisa.finalblog.model;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String roleName;

    @Override
    public String getAuthority() {
        return "ROLE_" + roleName;
    }
}
