package web.spring.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.spring.management.model.Course;
import web.spring.management.repository.CourseDB;

@Service
public class CourseService {

    @Autowired
    private CourseDB courseDB;

    /**
     * Return all courses in the pae
     * @return Iterable list
     */
    public Iterable<Course> getCourses(){
        return courseDB.findAll();
    }

    public Optional<Course> getDetails(String id){
        return courseDB.findById(id);
    }

    /**
     * If it save with succes return the object
     * otherwise return null?
     * @param course
     * @return
     */
    public Course addCourse(Course course){
        return courseDB.save(course);
    }


    public List<Course> creaditsGreateThanEqual(int credits){
        return courseDB.findByCreditsGreaterThanEqual(credits);
    }




}
