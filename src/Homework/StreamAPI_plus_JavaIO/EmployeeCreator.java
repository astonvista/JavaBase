package Homework.StreamAPI_plus_JavaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// Класс для создания экземпляра Employee из файла.
public class EmployeeCreator {

    public static List<Employee> create(File file) {
        List<Employee> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(" ");
                result.add(new Employee(temp[0].strip(),
                        Integer.parseInt(temp[1]),
                        Integer.parseInt(temp[2])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}


