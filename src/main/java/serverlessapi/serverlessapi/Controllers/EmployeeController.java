package serverlessapi.serverlessapi.Controllers;



import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {


    @GetMapping("/employees")
    public String getEmployees() {

        return "Get Employees.";
    }

    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable Long id){
        return "Employee ID  " + id;
    }

    @DeleteMapping("/employees")
    public String deleteEmployee (@RequestParam Long id)
    {
        return "Delete the employee details  " +  id;
    }
}
