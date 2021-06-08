package com.timlai.stockapp.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private BCryptPasswordEncoder passwordEncoder;

    public SecurityConfiguration(DataSource dataSource, BCryptPasswordEncoder passwordEncoder) {
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select user_id, user_password, enabled " +
                        "from stock_app_user where user_id = ?")
                .authoritiesByUsernameQuery("select user_id, role " +
                        "from stock_app_user where user_id = ?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    //This is for Authorization (User Roles)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //TODO Implement access specific to a user
                //Any User can access the / endpoint and any endpoint
                .antMatchers("/", "/**").permitAll()
                .and()
                .formLogin();
    }
}
