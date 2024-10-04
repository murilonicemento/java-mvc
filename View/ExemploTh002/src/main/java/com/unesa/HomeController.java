package com.unesa;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
    @GetMapping("/old")
    public String showHomeOld(Model model) {
        model.addAttribute("data", new Date());
        List<String> listDepartamentos = Arrays.asList("Financeiro", "Comercial", "Recursos Humanos");
        model.addAttribute("departamentos", listDepartamentos);
        return "home_tl";
    }
    
    @GetMapping("/")
    public String showHome(Model model) {
        return "home";
    }
    
    @GetMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }
    
    @GetMapping("/logout")
    public String showLogout(Model model) {
        return "logout";
    }

}
