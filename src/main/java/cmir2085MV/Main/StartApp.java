package cmir2085MV.Main;

//functionalitati
//F01.	 adaugarea unui nou angajat (nume, prenume, CNP, functia didactica, salariul de incadrare);
//F02.	 modificarea functiei didactice (asistent/lector/conferentiar/profesor) a unui angajat;
//F03.	 afisarea salariatilor ordonati descrescator dupa salariu si crescator dupa varsta (CNP).

import cmir2085MV.Controller.EmployeeController;
import cmir2085MV.Domain.DidacticFunction;
import cmir2085MV.Domain.Employee;
import cmir2085MV.Repository.EmployeeFileRepository;
import cmir2085MV.Repository.EmployeeRepository;
import cmir2085MV.Repository.EmployeeRepositoryInterface;

public class StartApp {
	
	public static void main(String[] args) {
		
		EmployeeRepositoryInterface employeesRepository = new EmployeeRepository();
        EmployeeRepositoryInterface employeesFileRepository = new EmployeeFileRepository();
		EmployeeController employeeController = new EmployeeController(employeesRepository);
        EmployeeController employeeFileController = new EmployeeController(employeesFileRepository);

		Employee Daria   = new Employee("Roman", "Daria", "2980221763738", DidacticFunction.ASISTENT, 25000);
		Employee Mark   = new Employee("Czeli", "Mark", "1970928783738", DidacticFunction.LECTURER, 2500);
		Employee Maria  = new Employee("Ionescu", "Maria", "5020221708078", DidacticFunction.LECTURER, 2500);

		employeeController.addEmployee( Daria );
		employeeController.addEmployee( Mark );
		employeeController.addEmployee( Maria );

        employeeFileController.addEmployee( Daria );
        employeeFileController.addEmployee( Mark );
        employeeFileController.addEmployee( Maria );

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
		    System.out.println(employee.toString());
	}

}
