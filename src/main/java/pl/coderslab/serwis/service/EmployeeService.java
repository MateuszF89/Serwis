package pl.coderslab.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.serwis.model.Employee;
import pl.coderslab.serwis.repository.EmployeeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findEmployee(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            throw new NoSuchElementException("Nie znaleziono obiektu klienta o podanym ID: " + id);
        }
    }

    public void editEmployee(Employee employee){

        employeeRepository.save(employee);
    }
}
