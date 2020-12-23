package lt.boreisa.finalblog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration

//[HERE WE CONFIG EVERYTHING RELATED WITH SPRING SECURITY]
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/h2/**", "/public/**", "/logout").permitAll()
                .antMatchers("/private/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .permitAll()
                    .loginPage("/private/main") //[GET METHOD - TO GET LOGIN PAGE]
                    .loginProcessingUrl("/public/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/private/main", true)
                    .failureForwardUrl("/public/login-error")
                    .and()
                .logout()
                    .logoutUrl("/logout");

        http
                .csrf().
                ignoringAntMatchers("/h2/**");

        http
                .headers()
                .frameOptions()
                .sameOrigin();
    }

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    //[CATCHING FROM DATABASE]
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }
}
