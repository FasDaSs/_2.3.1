package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;

import javax.transaction.Transactional;

@Controller
public class Start {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    @Transactional
    public String test(ModelMap model) {
        model.addAttribute("messages", userService.listUsers());
        return "index";
    }
}
