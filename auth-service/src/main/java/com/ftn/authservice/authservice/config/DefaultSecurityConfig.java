//package com.ftn.authservice.authservice.config;
//
//import com.ftn.authservice.authservice.service.CustomAuthenticationProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class DefaultSecurityConfig {
//
//    @Autowired
//    private CustomAuthenticationProvider customAuthenticationProvider;
//
//    @Autowired CORSCustomizer corsCustomizer;
//
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        corsCustomizer.corsCustomizer(http);
//        return http.formLogin()
//                .and()
//                .authorizeHttpRequests()
//                .anyRequest().authenticated()
//                .and().build();
//    }
//
//    @Autowired
//    public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
//        authenticationManagerBuilder
//                .authenticationProvider(customAuthenticationProvider);
//    }
//}
