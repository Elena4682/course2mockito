package pro.sky.course2mockito;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private static final int MAX_SIZE = 50;
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {

        if(!validateInput(firstName,lastName)){
            throw new InvalidInputException();
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee delete(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee delete(String firstName, String lastName, int department, int salary) {

        if(!validateInput(firstName,lastName)){
            throw new InvalidInputException();
        }

        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName, int department, int salary) {

        if(!validateInput(firstName,lastName)){
            throw new InvalidInputException();
        }

        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return employees;
    }

    @Override
    public Collection<Employee> getEmployees() {
        return null;
    }

    private boolean validateInput(String firstName, String lastName){
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }

}
