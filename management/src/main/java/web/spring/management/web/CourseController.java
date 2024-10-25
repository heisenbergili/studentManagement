package web.spring.management.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import web.spring.management.service.CourseService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("courses", courseService.getCourses());
        return "course";
    }

    @GetMapping("/details")
    public String details(@RequestParam("id") String id, Model model) {

        if (courseService.getDetails(id).isEmpty()) {
            model.addAttribute("detail", new ArrayList<>());            
        }else{
            model.addAttribute("detail", courseService.getDetails(id).get());
        }
        return "details";
    }
    

}
