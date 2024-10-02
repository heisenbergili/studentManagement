package web.spring.management.model;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(generator = "id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_gen", initialValue = 58554)
    private String id; 
    private String title; 
    private int credits; 


    @ManyToMany(mappedBy = "courses")
    private Collection<Student> students;

}
