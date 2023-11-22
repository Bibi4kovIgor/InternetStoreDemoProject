package edu.lemon.internetstore.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class AuthConfig {
    @Bean
    public SecurityFilterChain oauthFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
//                .csrf(withDefaults())
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/admin/**").hasAuthority("ADMIN")) // ROLE_ will be added automatically
                        .anyRequest().permitAll())
//                        .formLogin(withDefaults())
                .httpBasic(withDefaults())
//                .oauth2Login(withDefaults())
                .logout(spec -> spec.logoutUrl("/auth/logout").invalidateHttpSession(true).deleteCookies())
                .build();
    }

}
