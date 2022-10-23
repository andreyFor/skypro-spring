
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    List<Employee> arr = new ArrayList<>();

    public String getMaxDepartmentSalary(int department) {
        Optional<Employee> employee = arr.stream()
                .filter(man -> man.getDepartment() == (department))
                .max(Comparator.comparing(Employee::getSalaryInfo));
        return employee.toString();
    }

    public String getMinDepartmentSalary(int department) {
        Optional<Employee> employee = arr.stream()
                .filter(man -> man.getDepartment() == (department))
                .min(Comparator.comparing(Employee::getSalaryInfo));
        return employee.toString();
    }


    public String getAllDepartmentEmployee(int department) {
        List<Employee> employee = arr.stream()
                .filter(man -> man.getDepartment() == (department))
                .collect(Collectors.toList());
        return employee.toString();
    }

    public String getAllEmployeers() {

        List<Employee> employee = arr.stream()
                .sorted().collect(Collectors.toList());
        return employee.toString();
    }
}