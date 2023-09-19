package pl.coderslab.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.serwis.model.Employee;
import pl.coderslab.serwis.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/listOfEmployees")
    public String showAllEmployees(Model model) {
        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employess", employeeList);
        return "employee/listOfEmployees";
    }

    @GetMapping("/addEmployee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/add";
    }

    @PostMapping("/addEmployee")
    public String addEmployeeForm(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/add";
        }
        employeeService.addEmployee(employee);
        return "redirect:/employee/listOfEmployees";
    }

    @GetMapping("/editEmployee")
    public String editEmployee(@RequestParam("employeeId") Long id, Model model) {
        Employee employee = employeeService.findEmployee(id);
        model.addAttribute("employee", employee);

        return "employee/edit";
    }

    @PostMapping("/editEmployee")
    public String editPart(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/edit";
        }
        employeeService.editEmployee(employee);
        return "redirect:/employee/listOfEmployees";
    }

}
