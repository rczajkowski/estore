package pl.estore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by rafau on 2017-02-21.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService customSecurityService(){
        return new CustomSecurityService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/singup").permitAll()
                .antMatchers("/mycart").permitAll()
                .antMatchers("/my/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN").and().formLogin()
                    .loginPage("/login").permitAll().and()
                .logout()
                    .logoutUrl("/logmeout")
                    .logoutSuccessUrl("/").permitAll();

    }
}
