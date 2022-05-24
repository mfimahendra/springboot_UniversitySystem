package com.nuistindo.UniversitySystem.controller;

import com.nuistindo.UniversitySystem.model.StudentsModel;
import com.nuistindo.UniversitySystem.model.UsersModel;
import com.nuistindo.UniversitySystem.service.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentsController {

    private final StudentsServiceImpl studentsService;

    public StudentsController(StudentsServiceImpl studentsService) { this.studentsService = studentsService; }

    @GetMapping("/admin/student")
    public String getAdminStudentPage(Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("ListStudents", studentsService.findAllByOrderByIdAsc());
            return "admin_student";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @GetMapping("/admin/student/{id}")
    public String getAdminStudentDetailsPage(@PathVariable String id, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("student", studentsService.findOneStudent(id));
            return "admin_student_details";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @GetMapping("/admin/student/register")
    public String getNewStudent(Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("student", new UsersModel());
            return "admin_student_new";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @PostMapping("/admin/student/new")
    public String newStudent(@ModelAttribute StudentsModel studentsModel, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username_logged", loggedUsername);
            StudentsModel newStudent = studentsService.registerStudents(studentsModel.getId(), studentsModel.getName(), studentsModel.getMajor(), studentsModel.getCountry());
            return newStudent == null ? "error_page" : "redirect:/admin/student";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @PostMapping("/admin/student/edit")
    public String updateStudent(@ModelAttribute StudentsModel studentsModel, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username_logged", loggedUsername);
            StudentsModel upStudent = studentsService.updateStudent(studentsModel.getId(), studentsModel.getName(), studentsModel.getMajor(), studentsModel.getCountry());
            return upStudent == null ? "error_page" : "redirect:/admin/student";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @RequestMapping("/admin/student/delete/{id}")
    public String deleteStudent(Model model, HttpServletRequest request, @PathVariable String id) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            studentsService.deleteStudent(id);
            model.addAttribute("ListUsers", studentsService.findAllByOrderByIdAsc());
            return "redirect:/admin/student";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }



}
