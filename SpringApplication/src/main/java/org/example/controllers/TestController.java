package org.example.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/lorem")
    public String lorem() {
        return "test";
    }

    @GetMapping(value = "/html_string", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String htmlString() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "Lorem ipsum dolor sit amet!\n" +
                "</body>\n" +
                "</html>";
    }
}
