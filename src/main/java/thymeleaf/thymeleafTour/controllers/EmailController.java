package thymeleaf.thymeleafTour.controllers;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import thymeleaf.thymeleafTour.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;
    @GetMapping("/sent")
    public String sendEmail(@RequestParam(value = "name", required = false, defaultValue = "Guest") String name){
        final String sendTo = "zhang.yu4@husky.neu.edu";
        this.emailService.sendComplexEmail(sendTo, name);
        return "Email has been sent to " + sendTo;
    }
    @GetMapping("/reset-password")
    public String resetPasswordByEmail(@RequestParam(value = "name", required = false, defaultValue = "Guest") String email){
        final String sendTo = "zhang.yu4@husky.neu.edu";
        Map<String, String> contextMap = new HashMap<>();
        contextMap.put("email", email);
        this.emailService.sendComplexEmail(sendTo, email);
        return "Email has been sent to " + sendTo;
    }


}