package web.spring.management.repository;

import org.springframework.data.repository.CrudRepository;

import web.spring.management.model.Course;

public interface CourseDB extends CrudRepository<Course, String> {

}
