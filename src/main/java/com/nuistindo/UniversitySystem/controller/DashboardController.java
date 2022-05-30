package com.nuistindo.UniversitySystem.controller;

import com.nuistindo.UniversitySystem.model.UsersModel;
import com.nuistindo.UniversitySystem.service.UsersServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DashboardController{

    private final UsersServiceImpl usersService;

    public DashboardController(UsersServiceImpl usersServiceImpl) {
        this.usersService = usersServiceImpl;
    }


    @GetMapping("/admin/dashboard")
    public String getAdminDashboardPage(Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("title","Welcome | " + loggedUsername);
            model.addAttribute("sidebarNav"," Dashboard");
            model.addAttribute("updateRequest", new UsersModel());
            model.addAttribute("ListUsers", usersService.listAllUsers());
            return "admin_dashboard";
        } catch (Exception e) {
            return "error_page";
        }
    }

    @PostMapping("/admin/dashboard/register")
    public String register(@ModelAttribute UsersModel usersModel , Model model) {
        try {
            UsersModel regist = usersService.registerUser(usersModel.getUsername(), usersModel.getPassword());
            return regist == null ? "error_page" : "redirect:/admin/dashboard";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @PostMapping("/admin/dashboard/edit")
    public String register(@ModelAttribute UsersModel usersModel, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username_logged", loggedUsername);
            UsersModel upAdmin = usersService.updateAdmin(usersModel.getId(), usersModel.getUsername(), usersModel.getPassword());
            return upAdmin == null ? "error_page" : "redirect:/admin/dashboard";
        } catch (Exception e) {
            return "error_page";
        }
    }

    @RequestMapping("/admin/dashboard/delete/{id}")
    public String deleteUser(Model model, HttpServletRequest request, @PathVariable Integer id) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            usersService.deleteUser(id);
            model.addAttribute("ListUsers", usersService.listAllUsers());
            return "redirect:/admin/dashboard";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @PostMapping("/admin/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }
}
