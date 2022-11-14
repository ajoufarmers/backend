package com.ajoufarmers.farmer.config;

import com.ajoufarmers.farmer.usermangement.login.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * referenced at https://dev-coco.tistory.com/128
 */
@EnableWebSecurity
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {

    //private final CustomUserDetailsService myUserDetailsService;

    //private final AuthenticationFailureHandler customFailureHandler;
    /* OAuth */
    private final CustomOAuth2UserService customOAuth2UserService;


    @Bean
    public BCryptPasswordEncoder Encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().ignoringAntMatchers("/api/**") /* REST API 사용 예외처리 */
//                .and()
//                .authorizeRequests()
//                .antMatchers("/", "/auth/**", "/posts/read/**", "/posts/search/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
////                .formLogin()
////                .loginPage("/login")
////                //.loginProcessingUrl("/auth/loginProc")
////                .defaultSuccessUrl("/")
////                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/")
//                .and() /* OAuth */
//                .oauth2Login()
//                .userInfoEndpoint() // OAuth2 로그인 성공 후 가져올 설정들
//                .userService(customOAuth2UserService); // 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**","/profile").permitAll()
                .antMatchers("/api/v1/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

        return http.build();
    }
}
