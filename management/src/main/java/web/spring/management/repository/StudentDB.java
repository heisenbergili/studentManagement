package web.spring.management.repository;

import java.util.List;

// import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import web.spring.management.model.Student;
import web.spring.management.model.enm.Section;

public interface StudentDB extends CrudRepository<Student,Integer> {

    //définir JPQL, DRIVERS, QUERY

    @Query("select SUM(s.number) from Student s where s.section = ?1" )
    int blabla(Section sec);

    //Question1
    @Query("select s.name from Student s")
    List<String> getAllNames();


    //Question2
    @Query("select s.name, s.number FROM Student s")
    List<Object[]> getAllNamesAndIds();

    //Question3
    @Query("select s.name, SUM(c.credits)" + 
            "FROM Student s" +
            " JOIN s.courses c" +
            " GROUP BY s.name"
            )
    List<Object[]> getStudentWithItCredits();

    //Question4
    @Query("Select s.name " + 
    "From Student s " + 
    "Join s.courses c " + 
    "GROUP BY s.name " + 
    "HAVING SUM(c.credits) > ?1")
    List<String> namesOfStudentCreditsGreaterThan(int etcs);


    //Filter
    @Query("select s FROM Student s WHERE s.name LIKE ?1%")
    List<Student> findByNameLike(String name);

}
