package cmir2085MV.IntegrationTests;

import cmir2085MV.Controller.EmployeeController;
import cmir2085MV.Domain.DidacticFunction;
import cmir2085MV.Domain.Employee;
import cmir2085MV.Main.StartApp;
import cmir2085MV.Repository.EmployeeFileRepository;
import cmir2085MV.Repository.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class IntegrationTopDown extends Utils {

    StartApp startApp;
    EmployeeController employeeController;
    EmployeeFileRepository employeeFileRepository;
    BufferedWriter out;
    BufferedReader input;

    @Before
    public void setUp() throws Exception {
        startApp = new StartApp();
        employeeController = Mockito.mock(EmployeeController.class);
        employeeFileRepository = Mockito.mock(EmployeeFileRepository.class);
        out = Mockito.mock(BufferedWriter.class);
        input = Mockito.mock(BufferedReader.class);
    }

    @After
    public void tearDown() throws Exception {
        removeItems();
        System.out.println("Tested");
    }

    @Test
    public void addEmployee3() {
        Employee employee3 = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeController.addEmployee(employee3)).thenReturn(true);
        Boolean bool = employeeController.addEmployee(employee3);
        assertEquals(true, bool);
    }

    /*
    list: 1 element and cnp valid
     */
    @Test
    public void searchForEmployee2() {
        Employee employee = new Employee("M", "Prenume", "1234567891234", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeFileRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeFileRepository.searchForEmployee("12345678")).thenReturn(employee);
        Employee employee1 = employeeFileRepository.searchForEmployee("12345678");
        assertEquals(employee, employee1);
    }

    @Test
    public void sortingByCriteria3() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("Mo", "Prenume", "1800202891234", DidacticFunction.LECTURER, 3301);
        Employee employee2 = new Employee("Mi", "Prenume", "1900202891234", DidacticFunction.LECTURER, 3301);
        Mockito.when(employeeFileRepository.addEmployee(employee)).thenReturn(true);
        Mockito.when(employeeFileRepository.addEmployee(employee2)).thenReturn(true);
        employees.add(employee2);
        employees.add(employee);
        Mockito.when(employeeFileRepository.getEmployeeByCriteria()).thenReturn(employees);
        String lastName = employeeFileRepository.getEmployeeByCriteria().get(0).getLastName();
        assertEquals(employees.get(0).getLastName(), lastName);
    }

    @Test
    public void TopDownTesting() throws IOException, NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee("Nume", "Prenume", "1810202812345", DidacticFunction.LECTURER, 3308);
        Mockito.when(input.readLine()).thenReturn( "1", "Nume", "Prenume", "1810202812345", "LECTURER", "3308", "4");
        Field readLineField = StartApp.class.getDeclaredField("readLine");
        readLineField.setAccessible(true);
        readLineField.set(null, input);
        Field outField = StartApp.class.getDeclaredField("outWrite");
        outField.setAccessible(true);
        outField.set(null, out);
        StartApp.main(null);
        Mockito.verify(out, Mockito.times(1)).write(employee.toString());
    }

    @Test
    public void TopDownTesting2() throws IOException, NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee("Nume", "Prenume", "1810303812345", DidacticFunction.LECTURER, 3308);
        Mockito.when(input.readLine()).thenReturn("1", "Nume", "Prenume", "1810303812345", "LECTURER", "3308", "4");
        Field readLineField = StartApp.class.getDeclaredField("readLine");
        readLineField.setAccessible(true);
        readLineField.set(null, input);
        Field outField = StartApp.class.getDeclaredField("outWrite");
        outField.setAccessible(true);
        outField.set(null, out);
        StartApp.main(null);
        Mockito.verify(out, Mockito.times(1)).write(employee.toString());
        Mockito.when(input.readLine()).thenReturn("2", "1810303", "4");
        StartApp.main(null);
        Mockito.verify(out, Mockito.times(2)).write(employee.toString());
    }

    @Test
    public void TopDownTesting3() throws IOException, NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee("Nume", "Prenume", "1810202812345", DidacticFunction.LECTURER, 3308);
        Employee employee2 = new Employee("Nume", "Prenume", "1810303812345", DidacticFunction.LECTURER, 3308);
        Mockito.when(input.readLine()).thenReturn( "1", "Nume", "Prenume", "1810202812345", "LECTURER", "3308", "1", "Nume", "Prenume", "1810303812345", "LECTURER", "3308", "4");
        Field readLineField = StartApp.class.getDeclaredField("readLine");
        readLineField.setAccessible(true);
        readLineField.set(null, input);
        Field outField = StartApp.class.getDeclaredField("outWrite");
        outField.setAccessible(true);
        outField.set(null, out);
        StartApp.main(null);
        Mockito.verify(out, Mockito.times(1)).write(employee.toString());
        Mockito.verify(out, Mockito.times(1)).write(employee2.toString());
        Mockito.when(input.readLine()).thenReturn( "2", "1810303", "4");
        StartApp.main(null);
        Mockito.verify(out, Mockito.times(2)).write(employee2.toString());
        Mockito.when(input.readLine()).thenReturn("3", "4");
        StartApp.main(null);
        Mockito.verify(out, Mockito.times(2)).write(employee2.toString());
        Mockito.verify(out, Mockito.times(1)).write(employee.toString());
    }
}
