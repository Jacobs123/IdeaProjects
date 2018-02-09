package pl.portalpracowniczy.app.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping("/protectedLinks")
    public String getAnonymousPage() {
        return "protectedLinks";
    }

    @RequestMapping("/userPage")
    public String getUserPage() {
        return "userPage";
    }

    @RequestMapping("/adminPage")
    public String getAdminPage() {
        return "adminPage";
    }

    @RequestMapping("/loginEmployee")
    public String getAdminLoginPage() {
        return "login_emp";
    }

    @RequestMapping("/loginUser")
    public String getUserLoginPage() {
        return "login_usr";
    }

    @RequestMapping("/403")
    public String getAccessDeniedPage() {
        return "403";
    }
    }
