package com.nuistindo.UniversitySystem.controller;

import com.nuistindo.UniversitySystem.model.TeachersModel;
import com.nuistindo.UniversitySystem.service.TeachersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TeachersController {
    private final TeachersServiceImpl teachersService;

    public TeachersController(TeachersServiceImpl teachersService) { this.teachersService = teachersService; }

    @GetMapping("/admin/teacher")
    public String getAdminTeacherPage(Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("title","Teacher Page");
            model.addAttribute("listTeacher", teachersService.listAllTeachers());
            return "admin_teacher";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @GetMapping("/admin/teacher/{id}")
    public String getAdminTeacherDetailsPage(@PathVariable String id, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("idTeacher",id);
            model.addAttribute("title","Teacher Page | " + id);
            model.addAttribute("teacher", teachersService.findOneTeacher(id));
            return "admin_teacher_details";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @GetMapping("/admin/teacher/register")
    public String getNewTeacher(Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("title","Register New Teacher");
            model.addAttribute("teacher", new TeachersModel());
            return "admin_teacher_new";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @PostMapping("/admin/teacher/new")
    public String newTeacher(@ModelAttribute TeachersModel teachersModel, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username_logged", loggedUsername);
            TeachersModel newTeacher = teachersService.registerTeachers(teachersModel.getId(), teachersModel.getName(), teachersModel.getExpertise(), teachersModel.getPassword());
            return newTeacher == null ? "error_page" : "redirect:/admin/teacher";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @PostMapping("/admin/teacher/edit")
    public String updateTeacher(@ModelAttribute TeachersModel teachersModel, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username_logged", loggedUsername);
            TeachersModel upTeacher = teachersService.updateTeacher(teachersModel.getId(), teachersModel.getName(), teachersModel.getExpertise(), teachersModel.getPassword());
            return upTeacher == null ? "error_page" : "redirect:/admin/teacher";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @RequestMapping("/admin/teacher/delete/{id}")
    public String deleteTeacher(Model model, HttpServletRequest request, @PathVariable String id) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            teachersService.deleteTeacher(id);
            model.addAttribute("ListUsers", teachersService.listAllTeachers());
            return "redirect:/admin/teacher";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }
}
