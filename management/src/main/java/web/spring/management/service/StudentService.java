package web.spring.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.spring.management.model.Student;
import web.spring.management.model.enm.Section;
import web.spring.management.repository.StudentDB;


@Service
public class StudentService {


    @Autowired
    private StudentDB studentDB;

    public Iterable<Student> getStudents() {
        return studentDB.findAll(); 
    }


    public Student addStudent(Student student){
        return studentDB.save(student);
    }

    public Optional<Student> getStudent(int number){
        return studentDB.findById(number);
    }

    public int getByNumber(Section sec){
        return studentDB.blabla(sec);
    }


    public List<String> getAllNames(){
        return studentDB.getAllNames();
    }

    public List<Object[]> getAllNamesAndIds(){
        return studentDB.getAllNamesAndIds();
    }



    public List<Object[]> getStudentWithItCredits(){
        return studentDB.getStudentWithItCredits();
    }


    public List<String> namesOfStudentCreditsGreaterThan(int etcs){
        return studentDB.namesOfStudentCreditsGreaterThan(etcs);
    }
    

    public List<Student> findByNameLike(String name){
        return studentDB.findByNameLike(name);
    }
    

}
