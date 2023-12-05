package hh.sof05.dogbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

        @Autowired
        private UserDetailServiceImpl userDetailServiceImpl;

        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {
                http
                                .cors(cors -> {
                                        CorsConfiguration configuration = new CorsConfiguration();
                                        configuration.setAllowedOrigins(Arrays.asList("*"));
                                        configuration.setAllowedMethods(Arrays.asList("*"));
                                        configuration.setAllowedHeaders(List.of("*"));
                                        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                                        source.registerCorsConfiguration("/**", configuration);
                                        cors.configurationSource(request -> configuration);
                                })
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(antMatcher("/")).permitAll()
                                                .requestMatchers(antMatcher("/login")).permitAll()
                                                .requestMatchers(antMatcher("/css/**")).permitAll()
                                                // .requestMatchers(antMatcher("/h2-console/**")).permitAll()
                                                .requestMatchers(antMatcher("/rest/**")).permitAll()
                                                .anyRequest().authenticated())

                                .headers(headers -> headers
                                                .frameOptions(frameoptions -> frameoptions
                                                                .disable()))
                                .formLogin(formlogin -> formlogin
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/itemlist", true)
                                                .permitAll())
                                .logout(logout -> logout
                                                .permitAll());
                                // .exceptionHandling(exception -> exception
                                //                 .authenticationEntryPoint(unauthorizedEntryPoint()));
                return http.build();
        }

        @Bean
        public AuthenticationEntryPoint unauthorizedEntryPoint() {
                return new CustomAuthenticationEntryPoint("/");
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
        }

}
