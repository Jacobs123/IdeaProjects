package pl.portalpracowniczy.app.webapp.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Secured("USER_ROLE")
public class UserLoginController {

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @RequestMapping("/loginUser")
    public String getUserLoginPage() {
        return "login_usr";
    }

}
