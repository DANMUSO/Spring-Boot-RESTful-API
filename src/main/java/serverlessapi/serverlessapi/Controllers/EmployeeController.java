package serverlessapi.serverlessapi.Controllers;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import serverlessapi.serverlessapi.Models.Employees;

@RestController
public class EmployeeController {

    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;


    @GetMapping("/version")
    public String getAppDetails(){
        return appName + " _ " + appVersion;
    }

    @GetMapping("/employees")
    public String getEmployees() {

        return "Get Employees.";
    }

    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable Long id){
        return "Employee ID  " + id;
    }

    @PostMapping("/employees")
    public String SaveEmployees(@RequestBody Employees employees){

        return "Saving the staff to DB " + employees;
    }
    @DeleteMapping("/employees")
    public String deleteEmployee (@RequestParam Long id)
    {
        return "Delete the employee details  " +  id;
    }
}
