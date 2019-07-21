package com.circlee.bookbook.controller.view;

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
        return "view/index";
    }

}
