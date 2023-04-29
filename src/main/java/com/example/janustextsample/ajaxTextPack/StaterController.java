package com.example.janustextsample.ajaxTextPack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaterController {
    @RequestMapping("/ajax")
    String index(){
        return "ajax";
    }
}

