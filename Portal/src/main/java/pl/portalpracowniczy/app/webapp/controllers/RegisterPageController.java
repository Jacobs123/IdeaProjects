package pl.portalpracowniczy.app.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.portalpracowniczy.app.webapp.domain.User;
import pl.portalpracowniczy.app.webapp.service.implementation.EmailService;
import pl.portalpracowniczy.app.webapp.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterPageController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/signup")
    public String showRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @ResponseBody
    @PostMapping(value = "/signup")
    public String registerUserAction(@Valid User user, BindingResult result, Model model) {
        String returnPage = null;
        String message = null;

        User userExists = userService.findUserByEmail(user.getMail());
        if (userExists != null) {
            result.rejectValue("mail", "error.user", "Podany adres email jest już zarejestrowany w bazie");
            message = "Adres email istnieje w systemie";
        }
        if (result.hasErrors()) {
            returnPage = "registration";
        } else {
            userService.saveUser(user);
//            emailService.send(user.getMail(), "Portal pracowniczy link potwierdzający",
//                "http://localhost:8080/confirm?id=" + user.getConfirmationId());
            model.addAttribute("message", "Rejestracja przebiegła pomyślnie. W celu aktywacji konta proszę sprawdzić pocztę");
            model.addAttribute("user", new User());
            message = "Rejestracja przebiegła pomyślnie. W celu aktywacji konta proszę sprawdzić pocztę";
        }
        return message;
    }

    @ResponseBody
    @RequestMapping("/confirm")
    public String greeting(@RequestParam(value="id", required=true) String confirmationId, Model model) {

        User user = userService.getUserByConfirmationId(confirmationId);
        String message = "Invalid confirmation id. Contact us or try again.";
        if(user!=null){
            if(!user.isConfirmationStatus()){
                user.setConfirmationStatus(true);
                user.setConfirmationId(null);
                user.setActive(1);
                userService.update(user);
            }
            message = user.getName() + ", your account has been verified. You may now log in. ";
        }

        model.addAttribute("message", message);
        return message;
    }


}
