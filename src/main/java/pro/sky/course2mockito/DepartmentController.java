package pro.sky.course2mockito;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;
    public DepartmentController(DepartmentService service){
        this.service = service;
    }
    @GetMapping("/{id}/salary/sum")
    public Integer sum(@RequestParam int departmentId, @PathVariable int id){
        return service.sum(departmentId);
    }
    @GetMapping("/{id}/salary/max")
    public Employee max(@RequestParam int departmentId, @PathVariable int id){
        return service.max(departmentId);
    }
    @GetMapping("/{id}/salary/min")
    public Employee min(@RequestParam int departmentId,@PathVariable int id){
        return service.min(departmentId);
    }
    @GetMapping(value = "/{id}/employees ")
    public List<Employee> allByDept(@RequestParam int departmentId,@PathVariable int id){
        return service.allByDept(departmentId);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> all(){
        return service.all();
    }
}
