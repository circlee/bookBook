package com.circlee.bookbook.controller.view;

import com.circlee.bookbook.model.auth.CustomUserDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {


    @GetMapping({"", "/"})
    public String getIndex(){
        return "redirect:/view/index";
    }

    @GetMapping("/view/{path}")
    public String getViewIndex(@PathVariable String path, @AuthenticationPrincipal CustomUserDetail customUserDetail){

        if(customUserDetail != null && "index".equals(path)) {
            return "redirect:/view/search";
        }

        return "view/index";
    }

}
