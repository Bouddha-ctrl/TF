package com.ufr.croissantshow.security;

import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails  implements UserDetails {
    private User user;

    public MyUserDetails (User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role role = user.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !false;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
