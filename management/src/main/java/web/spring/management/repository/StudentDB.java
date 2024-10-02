package web.spring.management.repository;

import org.springframework.data.repository.CrudRepository;
import web.spring.management.model.Student;

public interface StudentDB extends CrudRepository<Student,Integer> {
}
