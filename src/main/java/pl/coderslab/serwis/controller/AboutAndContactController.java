package pl.coderslab.serwis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AboutAndContactController {

    @GetMapping("/contact/")
    public String contactBoard() {
        return "contactAndAbout/contact";
    }

    @GetMapping("/about/")
    public String aboutBoard() {
        return "contactAndAbout/about";
    }
}
