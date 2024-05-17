package org.example.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http)throws Exception{
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(
                manager->{
                    manager
                            .requestMatchers("/about", "/css/**", "/login", "/images/**").permitAll()
                            .requestMatchers("/test").hasAnyRole("STUDENT", "OPERATOR", "ADMIN")
                            .requestMatchers("/book", "/video", "/music").hasAnyRole("STUDENT", "OPERATOR","ADMIN")
                            .requestMatchers("/comment").hasAnyRole("OPERATOR","STUDENT")
                            .requestMatchers("/student", "/call").hasRole("OPERATOR")
                            .requestMatchers("/student/admin", "/book/admin", "/video/admin", "/music/admin").hasRole("ADMIN")
                            .anyRequest().authenticated();
                });
        http.formLogin(manager->{
            manager.loginPage("/login")
                    .usernameParameter("phone")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/");//agar ("/", true) qilinsa, har qanday holatda ham '/' yo`liga return qiladi.Agar true bolmasa logindan o`tgandan keyin qaysi yolga murojaat qilish kerek bo`lsa osha yo`lga jo`natadi
        });
        http.rememberMe(manager->{
            manager
                    .tokenValiditySeconds(20)//agar shu qoyilmasa default holatda 2 haftaga sessionga saqlaydi bu esa yaxshi emas
                    .rememberMeParameter("rem-me");
        });
        http.logout(manager->{
            manager.logoutUrl("/logout")
                    .logoutRequestMatcher
                            (new AntPathRequestMatcher("/logout","POST"));
        });
        http.userDetailsService(customUserDetailsService);
        return http.build();
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


}
