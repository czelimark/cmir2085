package cmir2085MV.Repository;

import cmir2085MV.Domain.DidacticFunction;
import cmir2085MV.Domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortEmployeeTest extends Utils {

    EmployeeRepositoryInterface employeeRepository;

    @Before
    public void setUp() throws Exception {
        employeeRepository = Mockito.mock(EmployeeFileRepository.class);
    }

    @After
    public void tearDown() throws Exception {
        removeItems();
        System.out.println("Tested");
    }

    @Test
    public void sortingByCriteria() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("M", "Prenume", "1800202891234", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(true);
        employees.add(employee);
        Mockito.when(employeeRepository.getEmployeeByCriteria()).thenReturn(employees);
        Integer nrEmployees = employeeRepository.getEmployeeByCriteria().size();
        assertEquals(employees.size(), nrEmployees.intValue());
    }

    @Test
    public void sortingByCriteria2() {
        List<Employee> employees = new ArrayList<>();
        Mockito.when(employeeRepository.getEmployeeByCriteria()).thenReturn(employees);
        Integer nrEmployees = employeeRepository.getEmployeeByCriteria().size();
        assertEquals(employees.size(), nrEmployees.intValue());
    }

    @Test
    public void sortingByCriteria3() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("Mo", "Prenume", "1800202891234", DidacticFunction.LECTURER, 3301);
        Employee employee2 = new Employee("Mi", "Prenume", "1900202891234", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee2)).thenReturn(true);
        employees.add(employee2);
        employees.add(employee);
        Mockito.when(employeeRepository.getEmployeeByCriteria()).thenReturn(employees);
        String lastName = employeeRepository.getEmployeeByCriteria().get(0).getLastName();
        assertEquals(employees.get(0).getLastName(), lastName);
    }
}
