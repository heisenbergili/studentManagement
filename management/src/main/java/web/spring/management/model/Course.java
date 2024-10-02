package web.spring.management.model;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private String id; 
    private String title; 
    private int credits; 


    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private Collection<Student> students;

}
