package com.shtramak.crm.controller;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    private static String USER = "springstudent";
    private static String PASSWORD = "springstudent";
    private static String URL = "jdbc:postgresql://localhost:5432/customer";

    @RequestMapping
    protected String helloPage(Model model) throws ServletException, IOException {
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Hello from Servlet! \n");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            messageBuilder.append("Driver not found \n");
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            messageBuilder.append("Connection was successful");
        } catch (SQLException e) {
            messageBuilder.append("Connection was unsuccessful");
        }

        String message = messageBuilder.toString();
        model.addAttribute("message", message);
        return "HelloPage";
    }
}
