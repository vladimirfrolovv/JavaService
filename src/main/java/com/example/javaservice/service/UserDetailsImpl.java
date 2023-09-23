//package com.example.javaservice.service;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.io.Serial;
//import java.util.Collection;
//@AllArgsConstructor
//public class UserDetailsImpl implements UserDetails {
//    @Serial
//    private static final long serialVersionUID = 1L;
//
//    private Long id;
//    private String login;
//    private String email;
//    @JsonIgnore
//    private String password;
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities ( ) {
//        return null;
//    }
//
//    @Override
//    public String getPassword ( ) {
//        return null;
//    }
//
//    @Override
//    public String getUsername ( ) {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired ( ) {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked ( ) {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired ( ) {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled ( ) {
//        return false;
//    }
//}
