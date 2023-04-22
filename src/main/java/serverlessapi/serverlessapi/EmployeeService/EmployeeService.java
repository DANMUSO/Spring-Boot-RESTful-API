package serverlessapi.serverlessapi.EmployeeService;

import serverlessapi.serverlessapi.Models.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employees> getEmployees ();

    Employees saveEmployee (Employees employees);


    Optional<Employees> getSingleEmployee(Long id);

    void deleteEmployee (Long id);


    Employees updateEmployee (Employees employees);

    List<Employees> getEmployeesByName(String name);

}
