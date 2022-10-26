

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    public final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
   public Employee add (@RequestParam("firstName")String name,
    @RequestParam ("lastName")String surname,
    @RequestParam ("department") int department,
    @RequestParam double salary) {
        return employeeService.add(name, surname, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam ("firstName")String name,
    @RequestParam ("lastName")String surname) {
        return employeeService.remove(name, surname);
    }

    @GetMapping(value = "/find")
    public Employee find (@RequestParam ("firstName")String name,
                           @RequestParam ("lastName")String surname) {
        return employeeService.find(name, surname);
    }

    @GetMapping("/all")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
}
//111