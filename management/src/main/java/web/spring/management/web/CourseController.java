package web.spring.management.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import web.spring.management.model.Course;
import web.spring.management.service.CourseService;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("courses", courseService.getCourses());
        model.addAttribute("course", new Course());
        System.out.println("Lààaaaaa : " + courseService.creaditsGreateThanEqual(6));
        //le nom contient un nom donné.
        return "course";
    }

    @GetMapping("/details")
    public String details(@RequestParam("id") String id, Model model) {

        if (courseService.getDetails(id).isEmpty()) {
            model.addAttribute("detail", new ArrayList<>());
        } else {
            // It's a good practice?
            model.addAttribute("detail", courseService.getDetails(id).get());
            model.addAttribute("students", courseService.getDetails(id).get().getStudents());
        }
        return "details";
    }

    @PostMapping("/add-course")
    public String postMethodName(@Valid Course course, Errors errors, Model model) {
        // add a course
        if (errors.hasErrors()) {
            model.addAttribute("courses", courseService.getCourses());
            return "course";

        }
        courseService.addCourse(course);
        return "redirect:/";
    }

}
