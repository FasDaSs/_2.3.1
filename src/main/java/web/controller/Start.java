package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Start {
    @GetMapping(value = "/")
    public String test(ModelMap model) {

        return "index";
    }
}
