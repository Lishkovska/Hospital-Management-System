package com.example.hospitalmanagementsystem.config;

import com.example.hospitalmanagementsystem.models.enums.RoleEnum;
import com.example.hospitalmanagementsystem.repository.NurseRepository;
import com.example.hospitalmanagementsystem.service.NurseUserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    //to do sled katovsichki html template sa gotovi da si dobavq permitite
   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/nurses/register").permitAll()
                       .requestMatchers("/", "/nurses/login", "/nurses/test",
                              "/nurses/login-error").permitAll()
                        .requestMatchers("/record/register").permitAll()
                      //  .requestMatchers("/record/register").hasRole(RoleEnum.ADMIN.name())
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> {
                    formLogin.loginPage("/nurses/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/nurses/login-error");
                }
        ).logout(
                logout -> {
                    logout.logoutUrl("/nurses/logout")
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true);
                }
        );
        return  httpSecurity.build();
    }
    @Bean
    public UserDetailsService userDetailsService(NurseRepository nurseRepository){
        return new NurseUserDetailService(nurseRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
