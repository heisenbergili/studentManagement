package web.spring.management.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import web.spring.management.model.Course;

public interface CourseDB extends CrudRepository<Course, String> {

    List<Course> findByCreditsGreaterThanEqual(int credits);
    List<Course> findByIdContaining(String name);

}
