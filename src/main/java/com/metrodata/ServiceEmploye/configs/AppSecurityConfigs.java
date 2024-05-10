// package com.metrodata.ServiceEmploye.configs;

// import org.springframework.boot.context.config.DelegatingApplicationListener;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
// //import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @SuppressWarnings("removal")
// @Configuration
// @EnableWebSecurity
// public class AppSecurityConfigs extends WebSecurityConfiguration {
//     @SuppressWarnings({ "deprecation"})
//     @Bean
//     public DelegatingApplicationListener myDelegatingApplicationListener() {
//         return new DelegatingApplicationListener();
//     }


//     //@Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth
//                 .inMemoryAuthentication()
//                 .withUser("student")
//                 .password("student")
//                 .roles("STUDENT")
//                 .and()
//                 .withUser("admin")
//                 .password("admin")
//                 .roles("ADMIN");
//     }

//     @SuppressWarnings({ "deprecation"})
//     //@Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//                 .requestMatchers(HttpMethod.POST, "/auth/add-role/registration").permitAll()
//                 .requestMatchers("/email/**").permitAll()
//                 .requestMatchers("/region/**").hasRole("STUDENT")
//                 .requestMatchers("/country/**").hasAnyRole("STUDENT", "ADMIN")
//                 .requestMatchers("/employee/**").hasRole("ADMIN")
//                 .anyRequest().permitAll().and().httpBasic();
//     }
// }


