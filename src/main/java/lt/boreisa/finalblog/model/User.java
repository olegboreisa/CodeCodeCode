package lt.boreisa.finalblog.model;

import lombok.Data;
import lt.boreisa.finalblog.validation.PasswordMatches;
import lt.boreisa.finalblog.validation.Phone;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "user")
@PasswordMatches
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date")
    @CreationTimestamp
    private LocalDate registrationDate;

    @Length(min = 3, message = "{nickname.error}")
    @Column(name = "username")
    private String username;

    @Length(min = 3, message = "{password.error}")
    @Column(name = "password")
    private String password;

    @NotEmpty (message = "{match.error}")
    @Transient
    private String matchPassword;

    @NotBlank(message = "{country.error}")
    @Column(name = "country")
    private String country;

    @Phone
    @Column(name = "phone_number")
    private String phoneNum;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotEmpty(message = "{role.error}")
    private Set<Role> role = new HashSet<>();

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user", targetEntity = Blog.class)
    //Blog.class is HANDLING MAPPING
    private Set<Blog> blogs = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
