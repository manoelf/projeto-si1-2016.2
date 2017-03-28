package br.edu.ufcg.computacao.si1.model.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/html/**", "/register").permitAll()
                .anyRequest().authenticated()
                .and()
        .formLogin()
                .loginPage("/user/login").permitAll()
                .successHandler(new AuthenticationHandler())
                .failureUrl("/login?error")
                .and()
        .logout().permitAll();
    }

//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select email as username,password as password, true as enabled from user_tb where email=?")
//                .authoritiesByUsernameQuery(
//                        "select email as username, role from user_tb where email=?");
//
//    }


//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select email as username,senha as password, true as enabled from tb_usuario where email=?")
//                .authoritiesByUsernameQuery(
//                        "select email as username, role from tb_usuario where email=?");
//
//        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryUser;
//        inMemoryUser= auth.inMemoryAuthentication();
//        inMemoryUser.withUser("admin").password("123").roles("USER");

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers(HttpMethod.POST, "/user");
//    }
}
