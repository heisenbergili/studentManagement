package web.spring.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import web.spring.management.repository.CourseDB;
import web.spring.management.repository.StudentDB;



@Controller
public class HomeController {
    @Autowired
    private CourseDB courseDB;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("courses", courseDB.findAll());
        return "course";
    }
    

}
