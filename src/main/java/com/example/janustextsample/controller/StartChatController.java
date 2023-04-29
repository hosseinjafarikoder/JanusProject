package com.example.janustextsample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartChatController {

    private static final Logger logger = LoggerFactory.getLogger(StartChatController.class);


    @RequestMapping("/chat")
    public String startChat(){
        return "textroomtest";
    }



//    @RequestMapping("/chat")
//    String startChat(Model model){
//        TextRoom textRoom = TextRoom.getInstance();
//        User user = new User();
//        model.addAttribute("user", user);
//        System.out.println("show form method : " + user);
//        return "textroomtest";
//    }

//    @GetMapping("/registerUser")
//    public String registerUser(Model model) {
////        TestDtoTimeleaf dto = new TestDtoTimeleaf();
//        User user = new User();
//        model.addAttribute("user", user);
//        System.out.println("show form method : " + user);
////        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
////        model.addAttribute("listProfession", listProfession);
//        return "textroomtest";
//    }


//    @PostMapping("/chat")
//    public String submitFormUser(@ModelAttribute("user") User user) {
//        System.out.println("submit form method : "+ user);
//        return "textroomtest";
//    }

}
