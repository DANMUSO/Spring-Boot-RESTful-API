package serverlessapi.serverlessapi.Controllers;



import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Qualifier("eService")

    @GetMapping("/version")
    public String getAppDetails(){
        return appName + " _ " + appVersion;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employees>> getEmployees() {

        return new ResponseEntity<List<Employees>>(eService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employees>> getEmployee(@PathVariable Long id){
        return new ResponseEntity<Optional<Employees>>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employees> SaveEmployees(@Valid @RequestBody Employees employees){

        return new ResponseEntity<>(eService.saveEmployee(employees), HttpStatus.OK) ;

    }
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee (@RequestParam Long id)
    {
       return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT) ;
    }

    @PutMapping("/updateemployee/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable Long id, @RequestBody  Employees employees){

        employees.setId(id);
        return new ResponseEntity<Employees>( eService.updateEmployee(employees), HttpStatus.OK);
    }

    @GetMapping("/employee/filterByName")
    public ResponseEntity<List<Employees>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<List<Employees>>(eService.getEmployeesByName(name), HttpStatus.OK);
    }



}
