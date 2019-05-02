package cmir2085MV.Main;

//functionalitati
//F01.	 adaugarea unui nou angajat (nume, prenume, CNP, functia didactica, salariul de incadrare);
//F02.	 modificarea functiei didactice (asistent/lector/conferentiar/profesor) a unui angajat;
//F03.	 afisarea salariatilor ordonati descrescator dupa salariu si crescator dupa varsta (CNP).

import cmir2085MV.Controller.EmployeeController;
import cmir2085MV.Domain.DidacticFunction;
import cmir2085MV.Domain.Employee;
import cmir2085MV.Domain.EmployeeValidator;
import cmir2085MV.Repository.EmployeeFileRepository;
import cmir2085MV.Repository.EmployeeRepository;
import cmir2085MV.Repository.EmployeeRepositoryInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartApp {


    private static BufferedReader readLine = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter outWrite = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        EmployeeRepositoryInterface employeesRepository = new EmployeeRepository();
        EmployeeRepositoryInterface employeesFileRepository = new EmployeeFileRepository();
        EmployeeController employeeController = new EmployeeController(employeesRepository);
        EmployeeController employeeFileController = new EmployeeController(employeesFileRepository);

        Employee Daria = new Employee("Roman", "Daria", "2980221763738", DidacticFunction.ASISTENT, 10000);
        Employee Mark = new Employee("Czeli", "Mark", "1970928783738", DidacticFunction.LECTURER, 3500);
        Employee Maria = new Employee("Ionescu", "Maria", "5020221708078", DidacticFunction.LECTURER, 3500);

        int userChoice, bool = 1;

        while(bool != 0) {

            userChoice = menu();

            switch (userChoice) {
                case 1:
                    //System.out.println("Dati numele: ");
                    String lastName = readLine.readLine();
                    //System.out.println("Dati prenumele: ");
                    String firstName = readLine.readLine();
                    //System.out.println("Dati cnp-ul: ");
                    String cnp = readLine.readLine();
                    //System.out.println("Dati functia: ");
                    DidacticFunction didacticFunction = DidacticFunction.valueOf(readLine.readLine());
                    //System.out.println("Dati salariul: ");
                    Integer salary = Integer.valueOf(readLine.readLine());
                    Employee employee = new Employee(lastName, firstName, cnp, didacticFunction, salary);
                    employeeFileController.addEmployee(employee);
                    outWrite.write(employee.toString());
                    break;
                case 2:
                    //System.out.println("Dati cnp-ul: ");
                    String cnp2 = readLine.readLine();
                    Employee employee2 = employeeFileController.searchForEmployee(cnp2);
                    outWrite.write(employee2.toString());
                    break;
                case 3:
                    List<Employee> employees = new ArrayList<>();
                    employees = employeeFileController.getEmployeesSorted();
                    for (Employee e : employees) {
                        outWrite.write(e.toString());
                    }
                    break;
                case 4:
                    bool = 0;
                    break;
                default:
                    break;
            }
        }

		/*employeeController.addEmployee( Daria );
		employeeController.addEmployee( Mark );
		employeeController.addEmployee( Maria );

        employeeFileController.addEmployee( Daria );
        employeeFileController.addEmployee( Mark );
        employeeFileController.addEmployee( Maria );

        System.out.println(employeeFileController.searchForEmployee(Daria.getCnp()));

        System.out.println("Consola");

		for(Employee _employee : employeeController.getEmployeesList())
			System.out.println(_employee.toString());
		System.out.println("-----------------------------------------");

        System.out.println("Fisier");

        for(Employee _employee : employeeFileController.getEmployeesList())
            System.out.println(_employee.toString());
        System.out.println("-----------------------------------------");

		employeeController.modifyEmployee(Maria, "TEACHER");
		employeeFileController.modifyEmployee(Maria, "TEACHER");

        System.out.println("Consola");

        for(Employee _employee : employeeController.getEmployeesList())
            System.out.println(_employee.toString());
        System.out.println("-----------------------------------------");

		for(Employee employee : employeeController.getEmployeesSorted())
		    System.out.println(employee.toString());*/
	}

    public static int menu() throws IOException {

        /*System.out.println("Alegeti o optiune");
        System.out.println("-------------------------\n");
        System.out.println("1 - Adauga angajat");
        System.out.println("2 - Cauta angajat");
        System.out.println("3 - Sorteaza angajati descrescator dupa salariu si crescator dupa varsta");
        System.out.println("4 - Iesi");*/

        String input = readLine.readLine();

        return Integer.valueOf(input);
    }

}
