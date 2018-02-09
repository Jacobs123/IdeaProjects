package pl.portalpracowniczy.app.webapp.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeLoginController {

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @RequestMapping("/loginEmployee")
    public String getAdminLoginPage() {
        return "login_emp";
    }

    }
