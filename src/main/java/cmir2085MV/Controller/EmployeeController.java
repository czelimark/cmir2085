package cmir2085MV.Controller;

import cmir2085MV.Domain.Employee;
import cmir2085MV.Repository.EmployeeRepositoryInterface;

import java.util.List;

public class EmployeeController {
	
	private EmployeeRepositoryInterface employeeRepository;
	
	public EmployeeController(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}
	
	public List<Employee> getEmployeesList() {
		return employeeRepository.getEmployeeList();
	}
	
	public void modifyEmployee(Employee oldEmployee, String function) {
		employeeRepository.modifyEmployee(oldEmployee, function);
	}

	public List<Employee> getEmployeesSorted() {
	    return employeeRepository.getEmployeeByCriteria();
    }

    public Employee searchForEmployee(String cnp) { return employeeRepository.searchForEmployee(cnp); }
	
}
