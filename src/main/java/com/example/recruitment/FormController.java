package com.example.recruitment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @GetMapping("/form")
    public ModelAndView showForm() {
        return new ModelAndView("form");
    }


}