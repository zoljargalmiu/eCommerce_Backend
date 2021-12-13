package Group2.miu.edu.demo.service.userDetails;

import Group2.miu.edu.demo.domain.User;
import Group2.miu.edu.demo.domain.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
//    private String role;
//    private boolean isActive;
    private Set<UserRole> roles;

    public MyUserDetails(User user) {
        userName = user.getUserName();
        password = user.getPassword();
        roles = Collections.singleton(user.getRole());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        //changed it to true by Zoloo
        return true;
    }
}
