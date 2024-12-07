package web.spring.management.model;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import web.spring.management.model.enm.Gender;
import web.spring.management.model.enm.Section;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "courses")

/**
 * This class represent the table Student in the DB
 * and provides all functionalities to access it using Java code.
 */
public class Student {

    @Id
    @GeneratedValue(generator = "id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_gen", initialValue = 70000)
    private int number;
    @NotBlank(message = "name!!")
    private String name;
    //To store the object as a string in db
    @Enumerated(EnumType.STRING)
    @NotNull(message = "gender!!")
    private Gender gender;
    //To store the object as a string in db
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Section!!")
    private Section section;

    //A student can have a lot of courses
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Collection<Course> courses;
    

    public Student(String name, Section section, Gender gender){
        this.name = name;
        this.section = section;
        this.gender = gender;
    }

}
