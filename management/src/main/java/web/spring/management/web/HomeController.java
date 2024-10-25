package web.spring.management.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.spring.management.service.CourseService;



@Controller
public class HomeController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("courses", courseService.getCourses());
        return "course";
    }
    

}
