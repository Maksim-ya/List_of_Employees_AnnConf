package maksim_ya.listofemployees.controller;

import maksim_ya.listofemployees.model.Employee;
import maksim_ya.listofemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier(value = "EmployeeService")
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employees";
    }

    @RequestMapping (value = "/employees/add", method = RequestMethod.POST)
    public  String addEmployee(@ModelAttribute("employee") Employee employee){
        if(employee.getId()==0){
            this.employeeService.addEmployee(employee);
        }else {
            this.employeeService.updateEmployee(employee);
        }
        return "redirect:/employees";
    }

    @RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

    @RequestMapping("edit/{id}")
    public  String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee",this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employees";
    }

    @RequestMapping("employeedata/{id}")
    public String employeeData(@PathVariable("id") int id , Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        return  "employeedata";
    }
}
