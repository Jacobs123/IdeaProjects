package pl.portalpracowniczy.app.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.portalpracowniczy.app.webapp.domain.Company;
import pl.portalpracowniczy.app.webapp.domain.Employee;
import pl.portalpracowniczy.app.webapp.service.CompanyService;
import pl.portalpracowniczy.app.webapp.service.EmployeeRoleService;
import pl.portalpracowniczy.app.webapp.service.UserService;
import pl.portalpracowniczy.app.webapp.service.implementation.EmployeeService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class EmployerController {


    @Autowired
    CompanyService companyService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserService userService;
    @Autowired
    EmployeeRoleService employeeRoleService;

    @GetMapping("user/dashboard")
    private String mainPage(Model model, Principal principal) {
        System.out.println("Zalogowany jako" + principal.getName() + principal);
        model.addAttribute("user", userService.findUserByEmail(principal.getName()));
        return "user/user_dashboard";
    }


    /*
      Metoda zwraca widok fomularza do dodania firmy przed uzytkownika( pracodawce );
     */
    @GetMapping("user/createCompany")
    private String createCompany(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Company company = new Company();
                company.setUser(userService.findUserByEmail(auth.getName()));
                company.setName("EBIS");
                companyService.createEployee(company);
        return "user/create_company";
    }

    @PostMapping("user/createCompany")
    private String saveCompany(){

        return null;
    }
    /*
     Metoda zwraca widok fomularza do dodania pracownika
    */
    @GetMapping("user/createEmployee")
    private String displayEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "user/create_employee";
    }
    /*
    Metoda zapisuje pracownika do bazy danych
   */
    @PostMapping("user/creteEmployee")
    @ResponseBody
    private String createEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult){
        employeeService.createEployee(employee);
        return "Dodano nowego pracownika";
    }


    private String createEmployeePosition(){
        return null;
    }

}
