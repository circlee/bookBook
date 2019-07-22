package com.circlee.bookbook.controller.view;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping({"", "/"})
    public String getIndex(){
        return "redirect:/view/index";
    }

    @GetMapping({"/view/**"})
    public String getViewIndex(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        return "view/index";
    }

}
