package org.example.controllers;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @Autowired
    private UserRepository userRepository;

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

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/db_upd")
    @ResponseBody
    public String getUpdDB() {
        List<User> users = userService.getAll();

        StringBuilder sb = new StringBuilder();

        users.forEach(user -> sb.append(user.getId() + ": " + user.getLogin() + "<br>"));

        return sb.toString();
    }
}
