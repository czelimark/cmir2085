package cmir2085MV.Repository;

import cmir2085MV.Domain.DidacticFunction;
import cmir2085MV.Domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFileRepositoryTest {

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
        employeeRepository = new EmployeeFileRepository();
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
        System.out.println("Tested");
    }

    @Test
    public void addEmployee() {
        assertFalse(employeeRepository.addEmployee(employee));
    }

    @Test
    public void addEmployee2() {
        assertFalse(employeeRepository.addEmployee(employee2));
    }

    @Test
    public void addEmployee3() {
        assertTrue(employeeRepository.addEmployee(employee3));
    }

    @Test
    public void addEmployee4() {
        assertTrue(employeeRepository.addEmployee(employee4));
    }

    @Test
    public void addEmployee5() {
        assertTrue(employeeRepository.addEmployee(employee5));
    }

    @Test
    public void addEmployee6() {
        assertTrue(employeeRepository.addEmployee(employee6));
    }

    @Test
    public void addEmployee7() {
        assertFalse(employeeRepository.addEmployee(employee7));
    }

    @Test
    public void addEmployee8() {
        assertFalse(employeeRepository.addEmployee(employee8));
    }

    @Test
    public void addEmployee9() {
        assertTrue(employeeRepository.addEmployee(employee9));
    }

    @Test
    public void addEmployee10() {
        assertTrue(employeeRepository.addEmployee(employee10));
    }

    @Test
    public void addEmployee11() {
        assertTrue(employeeRepository.addEmployee(employee11));
    }

    @Test
    public void addEmployee12() {
        assertFalse(employeeRepository.addEmployee(employee12));
    }
}