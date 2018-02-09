package pl.portalpracowniczy.app.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MultipleLoginSecurityConfig {


    @Configuration
    @Order(1)
    @EnableGlobalMethodSecurity(securedEnabled = true)
    public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Qualifier("dataSource")
        @Autowired
        private DataSource dataSource;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;
        @Value("${spring.queries.roles-query}")
        private String rolesQuery;
        @Value("${spring.queries.users-query}")
        private String usersQuery;



        public App1ConfigurationAdapter() {
            super();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);


        }


                @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests().anyRequest().permitAll().and().
                        formLogin()
                    // log in
                .loginPage("/login_usr").loginProcessingUrl("/user_login").failureUrl("/loginUser?error=loginError").defaultSuccessUrl("/user/dashboard")
                // logout
                .and().logout().logoutUrl("/user_logout").logoutSuccessUrl("/protectedLinks").deleteCookies("JSESSIONID").and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
        }
    }

    /*
        Employee Config
     */
    @Configuration
    @Order(2)
    @EnableGlobalMethodSecurity(securedEnabled = true)
    public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {

        public App2ConfigurationAdapter() {
            super();
        }

        @Qualifier("dataSource")
        @Autowired
        private DataSource dataSource;
        @Value("${spring.queries.employees-query}")
        private String employeeQuery;
        @Value("${spring.queries.employeeroles-query}")
        private String employeeRolesQuery;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                 auth.jdbcAuthentication()
                     .dataSource(dataSource)
                     .usersByUsernameQuery(employeeQuery)
                     .authoritiesByUsernameQuery(employeeRolesQuery);
        }


        protected  void configure(HttpSecurity http) throws Exception {
                    http.formLogin()
                                .loginPage("/login_emp").failureUrl("/loginEmp?error=loginError").defaultSuccessUrl("/employee/main")
                                // logout
                                .and().logout().logoutUrl("/user_logout").logoutSuccessUrl("/protectedLinks").deleteCookies("JSESSIONID").and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
        }
    }

}
