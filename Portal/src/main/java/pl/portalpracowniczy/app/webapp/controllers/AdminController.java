package pl.portalpracowniczy.app.webapp.controllers;


import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    String logIn(){

        return "adminLogin";
    }

}
