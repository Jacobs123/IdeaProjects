package pl.portalpracowniczy.app.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.portalpracowniczy.app.webapp.service.implementation.EmailService;

@Controller
public class EmailController {

    private final EmailService emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailService emailSender, TemplateEngine templateEngine){
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }


    @RequestMapping("test")
    public String test(){
        return "home";
    }
}
