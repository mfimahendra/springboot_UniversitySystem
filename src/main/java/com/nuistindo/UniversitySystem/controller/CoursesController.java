package com.nuistindo.UniversitySystem.controller;

import com.nuistindo.UniversitySystem.model.CoursesModel;
import com.nuistindo.UniversitySystem.service.CoursesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CoursesController {
    private final CoursesServiceImpl coursesService;

    public CoursesController(CoursesServiceImpl coursesService) { this.coursesService = coursesService; }

    @GetMapping("/admin/course")
    public String getAdminCoursePage(Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("title","Courses Page");
            model.addAttribute("listCourses", coursesService.findAllByOrderByIdAsc());
            System.out.println(coursesService.findAllByOrderByIdAsc());
            return "admin_courses";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @GetMapping("/admin/course/{id}")
    public String getAdminCourseDetailsPage(@PathVariable String id, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("idCourse",id);
            model.addAttribute("title","Course Page | " + id);
            model.addAttribute("course", coursesService.findOneCourse(id));
            return "admin_courses_details";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @GetMapping("/admin/course/register")
    public String getNewCourse(Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            model.addAttribute("title","Register New Courses");
            model.addAttribute("course", new CoursesModel());
            return "admin_course_new";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @PostMapping("/admin/course/new")
    public String newCourse(@ModelAttribute CoursesModel coursesModel, Model model, HttpServletRequest request) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username_logged", loggedUsername);
            CoursesModel newCourse = coursesService.addCourse(coursesModel.getId(), coursesModel.getCourse(), coursesModel.getFaculty(), coursesModel.getTeacher_id());
            return newCourse == null ? "error_page" : "redirect:/admin/course";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @PostMapping("/admin/course/edit")
    public String updateCourse(@ModelAttribute CoursesModel coursesModel, Model model, HttpServletRequest request){
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username_logged", loggedUsername);
            CoursesModel upCourse = coursesService.updateCourse(coursesModel.getId(), coursesModel.getCourse(), coursesModel.getFaculty(), coursesModel.getTeacher_id());
            return upCourse == null ? "error_page" : "redirect:/admin/course";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }

    @RequestMapping("/admin/course/delete/{id}")
    public String deleteCourse(Model model, HttpServletRequest request, @PathVariable String id) {
        try {
            String loggedUsername = request.getSession().getAttribute("loggedUsername").toString();
            model.addAttribute("username", loggedUsername);
            coursesService.deleteCourse(id);
            return "redirect:/admin/course";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_page";
        }
    }
}
