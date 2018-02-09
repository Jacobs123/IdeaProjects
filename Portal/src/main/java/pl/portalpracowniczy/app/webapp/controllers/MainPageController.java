package pl.portalpracowniczy.app.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.portalpracowniczy.app.webapp.service.UserService;

import java.security.Principal;

@Controller
public class MainPageController {

        @Autowired
        UserService userService;

        /*Wyswietlenie głownej strony aplikacji*/
        @GetMapping("/")
        String homePage(){
            return "home";
        }
        /*Wyswietlenie strony z wyborem logowania*/

        @GetMapping("/login")
        String loginPage(){
        return "switch_login";
        }


}


