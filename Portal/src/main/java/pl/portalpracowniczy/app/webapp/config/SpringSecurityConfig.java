//package pl.portalpracowniczy.app.webapp.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Qualifier("dataSource")
//    @Autowired
//    private DataSource dataSource;
//
//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;
//    @Value("${spring.queries.users-query}")
//    private String usersQuery;
//    @Value("${spring.queries.employees-query}")
//    private String employeeQuery;
//    @Value("${spring.queries.employeeroles-query}")
//    private String employeeRolesQuery;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//            .usersByUsernameQuery(usersQuery)
//            .authoritiesByUsernameQuery(rolesQuery)
//            .dataSource(dataSource)
//            .passwordEncoder(bCryptPasswordEncoder);
//
//
//
//    }
//
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/").permitAll()
//            .antMatchers("/login").permitAll()
//            .antMatchers("/registration").permitAll()
//            .antMatchers("/admin/**").hasAuthority("ADMIN")
//            .and().csrf().disable().formLogin().loginPage("/login").loginProcessingUrl("/login").successForwardUrl("/home")
//            .and().csrf().disable().formLogin().loginPage("/employee_login").loginProcessingUrl("/employee_login").successForwardUrl("/home");
//
//
//    }
//
//    @Autowired
//    protected void configure2(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//            .usersByUsernameQuery(employeeQuery)
//            .authoritiesByUsernameQuery(employeeRolesQuery)
//            .dataSource(dataSource);
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//            .antMatchers("/resources/**", "/statics/**", "/templates/**");
//    }
//}
