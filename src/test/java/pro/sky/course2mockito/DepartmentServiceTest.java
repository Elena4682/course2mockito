package pro.sky.course2mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

 class DepartmentServiceTest {
    @Mock
    EmployeeServiceImpl employeeService;
    DepartmentService departmentService;
    List<Employee> DATASET = List.of(
            new Employee("name", "surname", 1,50000),
            new Employee("name1", "surname1", 2,55000),
            new Employee("name2", "surname2", 3,60000),
            new Employee("name3", "surname3", 1,65000));
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        departmentService = new DepartmentService(employeeService);
        when(employeeService.getEmployees()).thenReturn(DATASET);
    }
    @Test

     void testSum(){
         var actual = departmentService.sum(1);
         assertEquals(11500,actual);
     }
    @Test
    void testMax(){
        var actual = departmentService.max(1);
        var expected = new Employee("name3", "surname3", 1,65000);
        assertEquals(expected,actual);
    }
    @Test
    void testMin(){
        var actual = departmentService.min(1);
        var expected = new Employee("name", "surname", 1,50000);
        assertEquals(expected,actual);
    }
    @Test

    void testAllByDept(){
       var firstDeptAll = departmentService.allByDept(1);
       assertEquals(firstDeptAll.size(),2);
       assertIterableEquals(List.of(DATASET.get(0),DATASET.get(3)),firstDeptAll);
    }
}
