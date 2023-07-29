package edu.library.controller;

import edu.library.annotation.ViewMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RouterController {

    @ViewMethod
    @GetMapping("/reader_list")
    public String readerPage(){
        return "reader";
    }

    @ViewMethod
    @GetMapping("/book_list")
    public String bookPage(){
        return "book";
    }

    @ViewMethod
    @GetMapping("/type_list")
    public String typePage(){
        return "type";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @ViewMethod
    @GetMapping({"/main","/"})
    public String mainPage(){
        return "main";
    }
}
