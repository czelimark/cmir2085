package cmir2085MV.Repository;

import cmir2085MV.Domain.DidacticFunction;
import cmir2085MV.Domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
    private final String employeeDBFile = "D:\\Faculta_Mark\\Anul_3\\Semestrul_2\\VSS\\cmir2085\\employees.txt";

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
        removeItems();
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
        assertFalse(employeeRepository.addEmployee(employee6));
    }

    @Test
    public void addEmployee7() {
        assertFalse(employeeRepository.addEmployee(employee7));
    }

    @Test
    public void addEmployee8() {
        assertTrue(employeeRepository.addEmployee(employee8));
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

    /*
    list: empty
    */
    @Test
    public void searchForEmployee() {
        assertNull(employeeRepository.searchForEmployee("12345678"));
    }

    /*
    list: 1 element and cnp valid
     */
    @Test
    public void searchForEmployee2() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        employeeRepository.addEmployee(employee);
        assertTrue(employee.equals(employeeRepository.searchForEmployee("12345678")));
    }

    /*
    list: 1 element and cnp valid but not found
     */
    @Test
    public void searchForEmployee3() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        employeeRepository.addEmployee(employee);
        assertNull(employeeRepository.searchForEmployee("46738"));
    }

    /*
    list: 2 elements and cnp valid
     */
    @Test
    public void searchForEmployee4() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Employee employee2 = new Employee("M", "Prenume", "1234567891233", DidacticFunction.LECTURER, 3301);
        employeeRepository.addEmployee(employee);
        employeeRepository.addEmployee(employee2);
        assertTrue(employee2.equals(employeeRepository.searchForEmployee("1234567891233")));
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
        employeeRepository.addEmployee(employee);
        employeeRepository.addEmployee(employee2);
        employeeRepository.addEmployee(employee3);
        employeeRepository.addEmployee(employee4);
        employeeRepository.addEmployee(employee5);
        employeeRepository.addEmployee(employee6);
        employeeRepository.addEmployee(employee7);
        assertNull(employeeRepository.searchForEmployee("1234567891230"));
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
        employeeRepository.addEmployee(employee);
        employeeRepository.addEmployee(employee2);
        employeeRepository.addEmployee(employee3);
        employeeRepository.addEmployee(employee4);
        employeeRepository.addEmployee(employee5);
        employeeRepository.addEmployee(employee6);
        employeeRepository.addEmployee(employee7);
        employeeRepository.addEmployee(employee8);
        employee8.equals(employeeRepository.searchForEmployee("1234567892638"));
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
        employeeRepository.addEmployee(employee);
        employeeRepository.addEmployee(employee2);
        employeeRepository.addEmployee(employee3);
        employeeRepository.addEmployee(employee4);
        employeeRepository.addEmployee(employee5);
        employeeRepository.addEmployee(employee6);
        employeeRepository.addEmployee(employee7);
        employeeRepository.addEmployee(employee8);
        employeeRepository.addEmployee(employee9);
        assertTrue(employee6.equals(employeeRepository.searchForEmployee("12345678")));
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
        employeeRepository.addEmployee(employee);
        employeeRepository.addEmployee(employee2);
        employeeRepository.addEmployee(employee3);
        employeeRepository.addEmployee(employee4);
        employeeRepository.addEmployee(employee5);
        employeeRepository.addEmployee(employee6);
        employeeRepository.addEmployee(employee7);
        employeeRepository.addEmployee(employee8);
        employeeRepository.addEmployee(employee9);
        employee6.equals(employeeRepository.searchForEmployee("12345678"));
    }

    public void removeItems() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(employeeDBFile, false));
            bw.write(employee.toString());
            bw.newLine();
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}