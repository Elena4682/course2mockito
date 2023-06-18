package pro.sky.course2mockito;
import org.apache.commons.lang3.StringUtils;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int department;
    private final int salary;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ( firstName:" + firstName + " , lastName:" + lastName + " , department:" + department
                + " , salary:" + salary + " ) ";
    }

    @Override
    public boolean equals(Object i) {
        if (this == i) return true;
        if (i == null || getClass() != i.getClass()) return false;
        Employee employee = (Employee) i;
        return department == employee.department && salary == employee.salary && firstName.equals(employee.firstName)
                & lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName, department, salary);
    }

    public static Integer sum(Integer integer, Integer integer1){

        return integer;
    }

}
