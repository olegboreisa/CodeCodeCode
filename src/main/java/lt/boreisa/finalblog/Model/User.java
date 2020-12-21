package lt.boreisa.finalblog.Model;

import lombok.Data;
import lombok.NonNull;
import lt.boreisa.finalblog.Validation.PasswordMatches;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;

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

    @NotNull
    @NotEmpty
    @Column(name = "password")
    private String password;

    @Column(name = "matching_password")
    private String matchPassword;

    @Column(name = "country")
    private String country;

    @Column(name = "phone_number")
    private String phoneNum;

    @ManyToMany
    @Column(name = "role")
    private Set<Role> role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
