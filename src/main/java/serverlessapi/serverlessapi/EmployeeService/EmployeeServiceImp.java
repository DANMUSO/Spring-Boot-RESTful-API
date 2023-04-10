package serverlessapi.serverlessapi.EmployeeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serverlessapi.serverlessapi.Models.Employees;
import serverlessapi.serverlessapi.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;


    @Override
    public List<Employees> getEmployees(){
        return eRepository.findAll();


    }

    @Override
    public Employees saveEmployee(Employees employees) {
      return  eRepository.save(employees);
    }

    @Override
    public Optional<Employees> getSingleEmployee(Long id) {
       return eRepository.findById(id);
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Employees updateEmployee(Employees employees) {
        return eRepository.save(employees);
    }
}
