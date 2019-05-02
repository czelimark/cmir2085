package cmir2085MV.Repository;

import cmir2085MV.Domain.DidacticFunction;
import cmir2085MV.Domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class AddEmployeeTest extends Utils {

    Employee employee;
    Employee employee2;
    Employee employee3;
    Employee employee4;
    Employee employee5;
    Employee employee6;
    Employee employee7;
    Employee employee8;
    Employee employee9;
    Employee employee10;
    Employee employee11;
    Employee employee12;
    EmployeeRepositoryInterface employeeRepository;

    @Before
    public void setUp() throws Exception {
        employeeRepository = Mockito.mock(EmployeeFileRepository.class);
        employee = new Employee("", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        employee2 = new Employee(null, "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        employee3 = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        employee4 = new Employee("Msgbfksbdgkjdgbkjbdgksbdghsdgbjhbdgjhbdgbdsdgbdjhgbdjbdbdgjbdbdbdgsbdghsdbghsbdghsbdgbsdgbsdgbsjbdgjshdghsdughsuidghsuidghuisdghuisdhguishdguishduighsuidhguidhsguihduighsuidghuisdhguishduighsuighsuidghuisdhguishdsuighdhtgyudiswertgdjunfiktorkjdghstudkdddd", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        employee5 = new Employee("MMsgbfksbdgkjdgbkjbdgksbdghsdgbjhbdgjhbdgbdsdgbdjhgbdjbdbdgjbdbdbdgsbdghsdbghsbdghsbdgbsdgbsdgbsjbdgjshdghsdughsuidghsuidghuisdghuisdhguishdguishduighsuidhguidhsguihduighsuidghuisdhguishduighsuighsuidghuisdhguishdsuighdhtgyudiswertgdjunfiktorkjdghstudkdd", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        employee6 = new Employee("MMsgbfksbdgkjdgbkjbdgksbdghsdgbjhbdgjhbdgbdsdgbdjhgbdjbdbdgjbdbdbdgsbdghsdbghsbdghsbdgbsdgbsdgbsjbdgjshdghsdughsuidghsuidghuisdghuisdhguishdguishduighsuidhguidhsguihduighsuidghuisdhguishduighsuighsuidghuisdhguishdsuighdhtgyudiswertgdjunfiktorkjdghstudkdddd", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        employee7 = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3300);
        employee8 = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        employee9 = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3302);
        employee10 = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 11998);
        employee11 = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 11999);
        employee12 = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 12000);
    }

    @After
    public void tearDown() throws Exception {
        removeItems();
        System.out.println("Tested");
    }

    @Test
    public void addEmployee() {
        Mockito.when(employeeRepository.addEmployee(employee)).thenReturn(false);
        Boolean bool = employeeRepository.addEmployee(employee);
        assertEquals(false, bool);
    }

    @Test
    public void addEmployee2() {
        Mockito.when(employeeRepository.addEmployee(employee2)).thenReturn(false);
        Boolean bool = employeeRepository.addEmployee(employee2);
        assertEquals(false, bool);
    }

    @Test
    public void addEmployee3() {
        Mockito.when(employeeRepository.addEmployee(employee3)).thenReturn(true);
        Boolean bool = employeeRepository.addEmployee(employee3);
        assertEquals(true, bool);
    }

    @Test
    public void addEmployee4() {
        Mockito.when(employeeRepository.addEmployee(employee4)).thenReturn(true);
        Boolean bool = employeeRepository.addEmployee(employee4);
        assertEquals(true, bool);
    }

    @Test
    public void addEmployee5() {
        Mockito.when(employeeRepository.addEmployee(employee5)).thenReturn(true);
        Boolean bool = employeeRepository.addEmployee(employee5);
        assertEquals(true, bool);
    }

    @Test
    public void addEmployee6() {
        Mockito.when(employeeRepository.addEmployee(employee6)).thenReturn(false);
        Boolean bool = employeeRepository.addEmployee(employee6);
        assertEquals(false, bool);
    }

    @Test
    public void addEmployee7() {
        Mockito.when(employeeRepository.addEmployee(employee7)).thenReturn(false);
        Boolean bool = employeeRepository.addEmployee(employee7);
        assertEquals(false, bool);
    }

    @Test
    public void addEmployee8() {
        Mockito.when(employeeRepository.addEmployee(employee8)).thenReturn(true);
        Boolean bool = employeeRepository.addEmployee(employee8);
        assertEquals(true, bool);
    }

    @Test
    public void addEmployee9() {
        Mockito.when(employeeRepository.addEmployee(employee9)).thenReturn(true);
        Boolean bool = employeeRepository.addEmployee(employee9);
        assertEquals(true, bool);
    }

    @Test
    public void addEmployee10() {
        Mockito.when(employeeRepository.addEmployee(employee10)).thenReturn(true);
        Boolean bool = employeeRepository.addEmployee(employee10);
        assertEquals(true, bool);
    }

    @Test
    public void addEmployee11() {
        Mockito.when(employeeRepository.addEmployee(employee11)).thenReturn(true);
        Boolean bool = employeeRepository.addEmployee(employee11);
        assertEquals(true, bool);
    }

    @Test
    public void addEmployee12() {
        Mockito.when(employeeRepository.addEmployee(employee12)).thenReturn(false);
        Boolean bool = employeeRepository.addEmployee(employee12);
        assertEquals(false, bool);
    }

}