package pl.portalpracowniczy.app.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.portalpracowniczy.app.webapp.repository.RoleRepository;
import pl.portalpracowniczy.app.webapp.service.CompanyService;
import pl.portalpracowniczy.app.webapp.service.implementation.EmailService;
import pl.portalpracowniczy.app.webapp.service.UserService;
import pl.portalpracowniczy.app.webapp.service.implementation.EmployeeService;

@SpringBootApplication
@EnableAutoConfiguration
public class WebappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	@Autowired
    UserService userService;
    @Autowired
	EmailService emailService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CompanyService companyService;


    @Override
    public void run(String... strings) throws Exception {

    }

}

