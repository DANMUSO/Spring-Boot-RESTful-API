package serverlessapi.serverlessapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serverlessapi.serverlessapi.Models.Employees;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {


   List<Employees> findByName(String name);

}
