package pro.sky.course2mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceImplTest {
    private EmployeeServiceImpl employeeService;
    @BeforeEach
    public void beforeEach(){
        employeeService = new EmployeeServiceImpl();
    }
    @Test
    public void addTest(){
        var expected = new Employee("na", "sur", 4,50000);
        var actual = employeeService.add("na", "sur", 4,50000);
        assertEquals(expected,actual);
    }
    @Test
    public void addNegativeTest(){
        employeeService.add("name", "surname", 1,50000);
        assertThrows(EmployeeAlreadyAddedException.class,() -> employeeService.add("name", "surname"
                , 1,50000));
    }
    @Test
    public void deleteTest(){
        var expected = employeeService.add("na", "sur", 4,50000);
        var actual = employeeService.delete("na", "sur", 4,50000);
        assertEquals(expected,actual);
    }
    @Test
    public void deleteNegativeTest(){
        employeeService.add("na", "sur", 4,50000);
        assertThrows(EmployeeNotFoundException.class,() -> employeeService.delete("name", "surname"
                , 1,50000));
    }
    @Test
    public void findTest(){
        var expected = employeeService.add("name", "surname", 1,50000);
        var actual = employeeService.find("name", "surname", 1,50000);
        assertEquals(expected,actual);
    }
    @Test
    public void findNegativeTest(){
        employeeService.add("name", "surname", 1,50000);
        assertThrows(EmployeeNotFoundException.class,() -> employeeService.find("na", "sur",
                4,50000));
    }

}
