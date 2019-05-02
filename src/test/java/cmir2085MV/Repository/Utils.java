package cmir2085MV.Repository;

import cmir2085MV.Domain.DidacticFunction;
import cmir2085MV.Domain.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    private final String employeeDBFile = "D:\\Faculta_Mark\\Anul_3\\Semestrul_2\\VSS\\cmir2085\\employees.txt";

    public void removeItems() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(employeeDBFile, false));
            bw.newLine();
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeList() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(employeeDBFile, false));
            bw.newLine();
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
