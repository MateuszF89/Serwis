package pl.coderslab.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.serwis.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
