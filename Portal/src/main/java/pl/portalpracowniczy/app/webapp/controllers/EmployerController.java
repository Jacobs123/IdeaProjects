package pl.portalpracowniczy.app.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.portalpracowniczy.app.webapp.domain.Company;
import pl.portalpracowniczy.app.webapp.domain.Employee;
import pl.portalpracowniczy.app.webapp.service.CompanyService;
import pl.portalpracowniczy.app.webapp.service.UserService;
import pl.portalpracowniczy.app.webapp.service.implementation.EmployeeService;

@Controller(value = "/employer")
public class EmployerController {


    @Autowired
    CompanyService companyService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserService userService;


    @GetMapping("employer/dashboard")
    private String mainPage(){
        return "employer_main";
    }

    /*
      Metoda zwraca widok fomularza do dodania firmy przed uzytkownika( pracodawce );
     */
    @GetMapping("employer/createCompany")
    private String createCompany(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Company company = new Company();
                company.setUser(userService.findUserByEmail(auth.getName()));
                company.setName("");
                companyService.createEployee(company);
        return "create_company";
    }

    @PostMapping("employer/createCompany")
    private String saveCompany(){

        return null;
    }

    @GetMapping("employer/creteEmployee")
    private String createEmployee(Model model){

        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        return "create_employee";
    }

    private String createEmployeePosition(){
        return null;
    }

}
