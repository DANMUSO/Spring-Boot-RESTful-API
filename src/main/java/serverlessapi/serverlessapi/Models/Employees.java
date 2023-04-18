package serverlessapi.serverlessapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@ToString

@Entity
@Table( name = "employee")
public class Employees {


    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    @NotBlank( message = "Name is required")
    @NotNull( message ="Name should not be empty" )
    @Column( name = "name")
    private String name;


    @Column( name = "age")
    private Long age = 0L;


    @NotBlank( message = "Location is required")
    @NotNull( message ="Location should not be empty" )
    @Column( name = "location")
    private String location;

    @NotBlank( message = "Email is required")
    @Email( message = "Example info@example.com")
    @NotNull( message ="Email should not be empty" )
    @Column( name = "email")
    private String email;

    @NotNull( message ="Department should not be empty" )
    @Column( name = "department")
    private String department;

    @NotNull( message ="Phonenumber should not be empty" )
    @Column( name = "phonenumber")
    private String phonenumber;

    @NotNull( message ="Position should not be empty" )
    @Column( name = "position")
    private String position;

    @CreationTimestamp
    @Column( name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column( name = "updated_at")
    private Date updatedAt;


}
