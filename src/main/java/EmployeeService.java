
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService {
    public static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String name, String surname) {
        return name + "|" + surname;
    }

    public Employee add(String name, String surname, int department, double salary) {
        Employee employee = new Employee(name, surname, department, salary);
        String key = getKey(name, surname);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        return employees.get(key);
    }
    public Employee find(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        return employees.get(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
}

