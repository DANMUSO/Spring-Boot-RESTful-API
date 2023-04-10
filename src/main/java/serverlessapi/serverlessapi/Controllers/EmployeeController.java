package serverlessapi.serverlessapi.Controllers;



import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import serverlessapi.serverlessapi.EmployeeService.EmployeeService;
import serverlessapi.serverlessapi.Models.Employees;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService eService;
    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;


    @GetMapping("/version")
    public String getAppDetails(){
        return appName + " _ " + appVersion;
    }

    @GetMapping("/employees")
    public List<Employees> getEmployees() {

        return eService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employees> getEmployee(@PathVariable Long id){
        return eService.getSingleEmployee(id);
    }

    @PostMapping("/employees")
    public Employees SaveEmployees(@Valid @RequestBody Employees employees){

        return eService.saveEmployee(employees);
    }
    @DeleteMapping("/employees")
    public void deleteEmployee (@RequestParam Long id)
    {
        eService.deleteEmployee(id);
    }

    @PutMapping("/updateemployee/{id}")
    public Employees updateEmployee(@PathVariable Long id, @RequestBody  Employees employees){

        employees.setId(id);
        return eService.updateEmployee(employees);
    }
}
