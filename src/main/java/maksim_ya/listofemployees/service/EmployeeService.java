package maksim_ya.listofemployees.service;

import maksim_ya.listofemployees.model.Employee;

import java.util.List;

/**
 * Created by User on 24/01/2017.
 */
public interface EmployeeService {
    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void removeEmployee(int id);

    public Employee getEmployeeById(int id);

    public List<Employee> listEmployees();
}
