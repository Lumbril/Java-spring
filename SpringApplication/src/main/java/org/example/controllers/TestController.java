package org.example.controllers;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private UserRepository userRepository;

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

    @RequestMapping("/db")
    @ResponseBody
    public String getDB() {
        Iterable<User> users = userRepository.findAll();

        StringBuilder sb = new StringBuilder();

        users.forEach(u -> sb.append(u.getId() + ": " + u.getLogin() + "<br>"));

        return sb.toString();
    }

    @RequestMapping("/db/add_user")
    @ResponseBody
    public String addUser() {
        User user = new User();
        user.setLogin("a" + userRepository.count());

        try {
            userRepository.save(user);

            return "Successful";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }
}
