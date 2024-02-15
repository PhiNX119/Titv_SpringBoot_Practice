package com.xuanphi.mvc.security;//package com.xuanphi.managestudent2.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//import java.security.PublicKey;
//
//@Configuration
//public class UserConfig {
//    @Bean
//    @Autowired
//    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT id, pw, active FROM accounts WHERE id=?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT id, role FROM roles WHERE id=?");
//        return jdbcUserDetailsManager;
//    }
//
////    @Autowired
////    private DataSource dataSource;
////
////    @Bean
////    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
////        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
////        return userDetailsManager;
////    }
//
////    @Bean
////    @Autowired
////    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
////        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
////        userDetailsManager.setDataSource(dataSource);
////        return userDetailsManager;
////    }
//
////    @Bean
////    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
////        UserDetails xuanphi = User
////                .withUsername("xuanphi")
////                .password("{noop}123456")
////                .roles("teacher")
////                .build();
////
////        UserDetails congthanh = User
////                .withUsername("congthanh")
////                .password("{noop}123456")
////                .roles("manager")
////                .build();
////
////        UserDetails vuduc = User
////                .withUsername("vuduc")
////                .password("{noop}123456")
////                .roles("admin")
////                .build();
////
////        return new InMemoryUserDetailsManager(xuanphi, congthanh, vuduc);
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(
//                configurer -> configurer
//                        .requestMatchers(HttpMethod.GET, "/students").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/students").hasAnyRole("MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/students").hasAnyRole("MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/students/**").hasAnyRole("ADMIN")
//        );
//
//        httpSecurity.httpBasic(Customizer.withDefaults());
//
//        httpSecurity.csrf(csrf -> csrf.disable());
//        // csrf = cross site request forgery
//
//        return httpSecurity.build();
//    }
//}
