package web.spring.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.spring.management.model.Course;
import web.spring.management.repository.CourseDB;

@Service
public class CourseService {

    @Autowired
    private CourseDB courseDB;

    public Iterable<Course> getCourses(){
        return courseDB.findAll();
    }


}
