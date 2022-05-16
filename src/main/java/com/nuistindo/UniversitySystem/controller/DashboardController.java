package com.nuistindo.UniversitySystem.controller;

import com.nuistindo.UniversitySystem.model.UsersModel;
import com.nuistindo.UniversitySystem.service.UsersServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController{

    private final UsersServiceImpl usersService;

    public DashboardController(UsersServiceImpl usersServiceImpl) {
        this.usersService = usersServiceImpl;
    }

    @GetMapping("/admin/dashboard")
    public String getAdminDashboardPage(UsersModel usersModel, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("ListUsers", usersService.listAllUsers());
            return "admin_dashboard";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }


}
