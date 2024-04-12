package com.ilerna.clientes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webapp")
public class entrada {
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        String valorfinal="./index";
        return valorfinal;
    }
    @GetMapping({"/saludar"})
    public String saludar(Model model) {
        //String valorfinal="./saludar";
        model.addAttribute("saludo", "hola mundo");
        return "./saludar";
    }




}
