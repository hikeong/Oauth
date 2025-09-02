package Oauth.Oauth.vo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.thymeleaf.util.StringUtils;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @Column(nullable = false, unique = true, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String nickname;

    @Column(nullable = false, length = 1)
    private String state;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.id;
    }

    @Override
    public boolean isAccountNonExpired() {
        if(StringUtils.equalsIgnoreCase(state, "A")) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if(StringUtils.equalsIgnoreCase(state, "L")) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if(StringUtils.equalsIgnoreCase(state, "P")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEnabled() {
        if(isCredentialsNonExpired() && isAccountNonExpired() && isAccountNonLocked()) {
            return true;
        }
        return false;
    }


}