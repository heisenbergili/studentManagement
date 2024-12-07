package web.spring.management.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import web.spring.management.model.Student;
import web.spring.management.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;


    //Show all students and give the object for the form
    @GetMapping("")
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getStudents());
        model.addAttribute("student", new Student("", null, null));
        return "student";
    }

    @PostMapping("add")
    public String postMethodName(@Valid Student student, Errors errors, Model model) {
        // add a course
        if (errors.hasErrors()) {
            model.addAttribute("students", studentService.getStudents());
            return "student";

        }
        studentService.addStudent(student);
        return "redirect:/student";
    }

    @GetMapping("details")
    public String getMethodName(@RequestParam int number ,Model model) {
        if (!studentService.getStudent(number).isPresent()) {
            model.addAttribute("student", new ArrayList<>());
        }else{
            model.addAttribute("student", studentService.getStudent(number).get());
            model.addAttribute("courses", studentService.getStudent(number).get().getCourses());
        }
        return "student-details";
    }


    @GetMapping("search")
    public String getNameLike(@RequestParam String name ,Model model) {
        model.addAttribute("students", studentService.findByNameLike(name));
        System.out.println("haa: " + studentService.findByNameLike(name).toString());
        model.addAttribute("student", new Student("", null, null));
        return "fragments/student-table";
    }
    
    
    


}
