package ch.fhnw.webec.booklist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/about")
public class AboutController {
    // directly as a String
    @GetMapping()
    @ResponseBody()
    public String about() {
        // language=HTML
        return """
                    <h1>COCK</h1>
                """;
    }
}