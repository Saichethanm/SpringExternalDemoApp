package com.saichethan.SpringBootProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SampleSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/","/home","/register","/addNewStudent").permitAll()
                .antMatchers("/books/**").hasAnyRole("STUDENT","ADMIN")
                .antMatchers("/students/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/logout")
                .permitAll().and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }

    // create two users, admin and user
    /*
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER","STUDENT")
//                .withUser("user").password(passwordEncoder().encode("password")).roles("USER","STUDENT")
                .and()
                .withUser("admin").password("password").roles("ADMIN")
//                .withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN")
                .and()
                .withUser("student1").password("1").roles("STUDENT").and()
//                .withUser("student1").password(passwordEncoder().encode("1")).roles("STUDENT").and()
                .withUser("student2").password("2").roles("STUDENT").and()
//                .withUser("student2").password(passwordEncoder().encode("2")).roles("STUDENT").and()
//                .withUser("student3").password(passwordEncoder().encode("3")).roles("STUDENT");
                .withUser("student3").password("3").roles("STUDENT");
    }
//
//    @Bean
//    PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
/*
     */

    /*

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("mary").password("test123").roles("MANAGER"))
                .withUser(users.username("susan").password("test123").roles("ADMIN"));
    }

     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Use jdbc authentication

        auth.jdbcAuthentication().dataSource(securityDataSource).usersByUsernameQuery("select user_id,password,enabled "
                        + "from users "
                        + "where user_id = ?")
                .authoritiesByUsernameQuery("select user_id,authority "
                        + "from authorities "
                        + "where user_id = ?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}