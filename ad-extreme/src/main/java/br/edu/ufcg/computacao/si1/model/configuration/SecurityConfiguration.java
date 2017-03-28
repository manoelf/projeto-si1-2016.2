package br.edu.ufcg.computacao.si1.model.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


/**
 * Created by gersonsales on 26/03/17.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/html/**", "*", "/user/**").permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .anyRequest().authenticated()
                .and()
        .formLogin()
                .loginPage("/user/login").permitAll()
                .successHandler(new AuthenticationHandler())
                .failureUrl("/login?error")
                .and()
        .logout().permitAll();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


        auth.jdbcAuthentication().dataSource(null)
                .usersByUsernameQuery(
                        "select email as username,password as password, true as enabled from user_tb where email=?")
                .authoritiesByUsernameQuery(
                        "select email as username, role from user_tb where email=?");


//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select email as username,senha as password, true as enabled from tb_usuario where email=?")
//                .authoritiesByUsernameQuery(
//                        "select email as username, role from tb_usuario where email=?");
//
//        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryUser;
//        inMemoryUser= auth.inMemoryAuthentication();
//        inMemoryUser.withUser("admin").password("123").roles("USER");
    }
}
