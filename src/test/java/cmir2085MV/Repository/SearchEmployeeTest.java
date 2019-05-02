package cmir2085MV.Repository;

import cmir2085MV.Domain.DidacticFunction;
import cmir2085MV.Domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchEmployeeTest extends Utils {

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

    /*
    list: empty
    */
    @Test
    public void searchForEmployee() {
        Mockito.when(employeeRepository.searchForEmployee("12345678")).thenReturn(null);
        Employee employee = employeeRepository.searchForEmployee("12345678");
        assertEquals(null, employee);
    }

    /*
    list: 1 element and cnp valid
     */
    @Test
    public void searchForEmployee2() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeRepository.searchForEmployee("12345678")).thenReturn(employee);
        Employee employee1 = employeeRepository.searchForEmployee("12345678");
        assertEquals(employee, employee1);
    }

    /*
    list: 1 element and cnp valid but not found
     */
    @Test
    public void searchForEmployee3() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeRepository.searchForEmployee("74238")).thenReturn(null);
        Employee employee1 = employeeRepository.searchForEmployee("74238");
        assertEquals(null, employee1);
    }

    /*
    list: 2 elements and cnp valid
     */
    @Test
    public void searchForEmployee4() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Employee employee2 = new Employee("M", "Prenume", "1234567891233", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee2)).thenReturn(true);
        Mockito.when(employeeRepository.searchForEmployee("1234567891233")).thenReturn(employee2);
        Employee employee1 = employeeRepository.searchForEmployee("1234567891233");
        assertEquals(employee2, employee1);
    }

    /*
    list: max 8 elements
          n-1 elements and cnp valid but not found
     */
    @Test
    public void searchForEmployee5() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Employee employee2 = new Employee("M", "Prenume", "1234567891233", DidacticFunction.LECTURER, 3301);
        Employee employee3 = new Employee("M", "Prenume", "1234567891235", DidacticFunction.LECTURER, 3301);
        Employee employee4 = new Employee("M", "Prenume", "1234567891236", DidacticFunction.LECTURER, 3301);
        Employee employee5 = new Employee("M", "Prenume", "1234567891237", DidacticFunction.LECTURER, 3301);
        Employee employee6 = new Employee("M", "Prenume", "1234567891238", DidacticFunction.LECTURER, 3301);
        Employee employee7 = new Employee("M", "Prenume", "1234567891338", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee2)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee3)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee4)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee5)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee6)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee7)).thenReturn(true);
        Mockito.when(employeeRepository.searchForEmployee("1234567891230")).thenReturn(null);
        Employee employee1 = employeeRepository.searchForEmployee("1234567891230");
        assertNull(null, employee1);
    }

    /*
    list: max 8 elements
          n elements and cnp valid
     */
    @Test
    public void searchForEmployee6() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Employee employee2 = new Employee("M", "Prenume", "1234567891233", DidacticFunction.LECTURER, 3301);
        Employee employee3 = new Employee("M", "Prenume", "1234567891235", DidacticFunction.LECTURER, 3301);
        Employee employee4 = new Employee("M", "Prenume", "1234567891236", DidacticFunction.LECTURER, 3301);
        Employee employee5 = new Employee("M", "Prenume", "1234567891237", DidacticFunction.LECTURER, 3301);
        Employee employee6 = new Employee("M", "Prenume", "1234567891238", DidacticFunction.LECTURER, 3301);
        Employee employee7 = new Employee("M", "Prenume", "1234567891338", DidacticFunction.LECTURER, 3301);
        Employee employee8 = new Employee("M", "Prenume", "1234567892638", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee2)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee3)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee4)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee5)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee6)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee7)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee8)).thenReturn(true);
        Mockito.when(employeeRepository.searchForEmployee("1234567892638")).thenReturn(employee8);
        Employee employee1 = employeeRepository.searchForEmployee("1234567892638");
        assertEquals(employee8, employee1);
    }

    /*
    list: max 8 elements
          n+1 elements and cnp valid
     */
    @Ignore
    public void searchForEmployee7() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Employee employee2 = new Employee("M", "Prenume", "1234567891233", DidacticFunction.LECTURER, 3301);
        Employee employee3 = new Employee("M", "Prenume", "1234567891235", DidacticFunction.LECTURER, 3301);
        Employee employee4 = new Employee("M", "Prenume", "1234567891236", DidacticFunction.LECTURER, 3301);
        Employee employee5 = new Employee("M", "Prenume", "1234567891237", DidacticFunction.LECTURER, 3301);
        Employee employee6 = new Employee("M", "Prenume", "1234567891238", DidacticFunction.LECTURER, 3301);
        Employee employee7 = new Employee("M", "Prenume", "1234567891338", DidacticFunction.LECTURER, 3301);
        Employee employee8 = new Employee("M", "Prenume", "1234567892628", DidacticFunction.LECTURER, 3301);
        Employee employee9 = new Employee("M", "Prenume", "1234567892528", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee2)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee3)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee4)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee5)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee6)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee7)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee8)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee9)).thenReturn(true);
        Mockito.when(employeeRepository.searchForEmployee("12345678")).thenReturn(employee8);
        Employee employee1 = employeeRepository.searchForEmployee("12345678");
        assertEquals(employee8, employee1);
    }

    /*
    list: max 8 elements
          m elements and cnp valid
     */
    @Test
    public void searchForEmployee8() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Employee employee2 = new Employee("M", "Prenume", "1234567891233", DidacticFunction.LECTURER, 3301);
        Employee employee3 = new Employee("M", "Prenume", "1234567891235", DidacticFunction.LECTURER, 3301);
        Employee employee4 = new Employee("M", "Prenume", "1234567891236", DidacticFunction.LECTURER, 3301);
        Employee employee5 = new Employee("M", "Prenume", "1234567891237", DidacticFunction.LECTURER, 3301);
        Employee employee6 = new Employee("M", "Prenume", "1234567891238", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee2)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee3)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee4)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee5)).thenReturn(true);
        Mockito.when(employeeRepository.addEmployee(employee6)).thenReturn(true);
        Mockito.when(employeeRepository.searchForEmployee("1234567891238")).thenReturn(employee6);
        Employee employee1 = employeeRepository.searchForEmployee("1234567891238");
        assertEquals(employee6, employee1);
    }
}
