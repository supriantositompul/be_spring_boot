// package com.metrodata.ServiceEmploye.Models;

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.metrodata.ServiceEmploye.Models.Entity.User;

// import lombok.AllArgsConstructor;

// @AllArgsConstructor
// public class AppUserDetail implements UserDetails {

//     private User user;

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         List<GrantedAuthority> authorities = new ArrayList<>();
//         user
//                 .getRoles()
//                 .forEach(role -> {
//                     String roles = "ROLE_" + role.getName().toUpperCase();
//                     authorities.add(new SimpleGrantedAuthority(roles));
//                     role
//                             .getPrivileges()
//                             .forEach(privilage -> {
//                                 String privileges = privilage.getName().toUpperCase();
//                                 authorities.add(new SimpleGrantedAuthority(privileges));
//                             });
//                 });

//         return authorities;
//     }

//     @Override
//     public String getPassword() {
//         return user.getPassword();
//     }

//     @Override
//     public String getUsername() {
//         return user.getUsername();
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return user.getIsEnabled();
//     }
// }
