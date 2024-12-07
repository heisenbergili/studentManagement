package web.spring.management.model;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    // @Pattern(regexp = "")
    @NotBlank(message = "Enter your id!")
    private String id; 
    @NotBlank(message = "Enter your title!")
    private String title; 
    @Positive
    private int credits; 


    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Collection<Student> students;

}
