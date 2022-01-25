package com.example.CodeJavaApp.controller;

import com.example.CodeJavaApp.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class PersonController {

    @GetMapping("/person")
    public String viewForm(Model model){
        model.addAttribute("person", new Person());
        return "person";
    }
    @PostMapping("/result")
    public String processForm(@ModelAttribute Person person, BindingResult result, Model model){
        model.addAttribute("person", person);
        return "result";
    }

}
