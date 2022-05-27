package company.hsenid.employeewebapplication.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String title;
    private String supervisor;

    @DBRef
    private Set<Employee> employees  = new HashSet<>();

}
