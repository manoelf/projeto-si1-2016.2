//package br.edu.ufcg.computacao.si1.model.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * Created by gersonsales on 26/03/17.
// */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/user/register", "/html/**").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/user/login").permitAll()
//                .and().logout().permitAll();
//    }
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryUser;
//        inMemoryUser= auth.inMemoryAuthentication();
//        inMemoryUser.withUser("admin").password("123").roles("USER");
//    }
//}
