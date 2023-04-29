package com.example.janustextsample.ajaxTextPack2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    @PostMapping("/api/testAjax")
    public void testAjaxMethod(){
        System.out.println("ajax run success...");
    }
}
