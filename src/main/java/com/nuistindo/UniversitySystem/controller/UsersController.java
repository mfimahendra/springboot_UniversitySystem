package com.nuistindo.UniversitySystem.controller;

import com.nuistindo.UniversitySystem.model.UsersModel;
import com.nuistindo.UniversitySystem.service.UsersServiceImpl;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.SessionScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UsersController {

    private final UsersServiceImpl usersService;

    public UsersController(UsersServiceImpl usersServiceImpl) {
        this.usersService = usersServiceImpl;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UsersModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UsersModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel) {
        UsersModel regist = usersService.registerUser(usersModel.getUsername(), usersModel.getPassword());
        return regist == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model, HttpServletRequest request) {
        UsersModel authenticated = usersService.authenticate(usersModel.getUsername(), usersModel.getPassword());
        HttpSession session = request.getSession();
        if (authenticated != null) {
            session.setAttribute("loggedUsername", authenticated.getUsername());
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("message", "Invalid username or password");
            return "login_page";
        }
    }
}
