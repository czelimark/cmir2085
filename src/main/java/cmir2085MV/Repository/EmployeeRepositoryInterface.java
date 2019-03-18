package cmir2085MV.Repository;

import cmir2085MV.Domain.Employee;
import cmir2085MV.Domain.EmployeeException;

import java.util.List;

public interface EmployeeRepositoryInterface {
	
	boolean addEmployee(Employee employee);
	boolean modifyEmployee(Employee oldEmployee, String function);
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeByCriteria();

}
