package com.kietnguyen.kotiki.SecurityConfig;

import com.kietnguyen.services.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/managerView/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/managerTool/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/cat/**").hasAnyAuthority( "ROLE_ADMIN")
                .antMatchers("/owner/**").hasAnyAuthority( "ROLE_ADMIN")
                .antMatchers("/user/**").hasAnyAuthority( "ROLE_ADMIN")
                .antMatchers("/role/**").hasAnyAuthority( "ROLE_ADMIN")
                .antMatchers("/filtering/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                .antMatchers("/").permitAll()
                .and()
            .formLogin()
                .defaultSuccessUrl("/welcomePage")
                .failureUrl("/loginError")
                .loginPage("/loginPage")//
                .usernameParameter("username")//
                .passwordParameter("password")
                .and()
            .exceptionHandling()
                .accessDeniedPage("/403");
    }
}
