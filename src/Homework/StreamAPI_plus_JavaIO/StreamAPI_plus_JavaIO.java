package Homework.StreamAPI_plus_JavaIO;

import java.io.File;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamAPI_plus_JavaIO {

    public static void main(String[] args) {
        //Создание списка Employee из файла.
        List<Employee> employeeList = EmployeeCreator.create(new File("ListOfEmployees.txt"));

        //Назначение Employee проектов.
        employeeList.get(0).assignProject(List.of(
                new Project("Alfa", 9),
                new Project("Bravo", 6),
                new Project("Charlie", 8)));

        employeeList.get(1).assignProject(List.of(
                new Project("Delta", 12),
                new Project("Echo", 4),
                new Project("Alfa", 2)));

        employeeList.get(2).assignProject(List.of(
                new Project("Echo", 8),
                new Project("Bravo", 4),
                new Project("Delta", 5)));

        employeeList.get(3).assignProject(List.of(
                new Project("Foxtrot", 12),
                new Project("Alfa", 9),
                new Project("Charlie", 6)));

        employeeList.get(4).assignProject(List.of(
                new Project("Echo", 5),
                new Project("Bravo", 3),
                new Project("Foxtrot", 8)));

        employeeList.get(5).assignProject(List.of(
                new Project("Alfa", 14),
                new Project("Delta", 6),
                new Project("Charlie", 8)));

        //Сериализация каждого Employee из коллекции в отдельный файл.
        Serializer.serialize(employeeList, "Employee_");

        //Выполнение условий фильтрации и сортировки, упаковка.
        Map<String, Double> result = employeeList.stream()
                .filter(employee -> (employee.getAge() > 30 && employee.getAge() < 50))
                .filter(employee -> employee.getSalary() > 60000)
                .flatMap(employee -> employee.getProjects().stream())
                .filter(project -> project.getDuration() > 6)
                .sorted(Comparator.comparing(Project::getDuration).reversed())
                .collect(Collectors.groupingBy(
                        project -> project.getName().toUpperCase(),
                        LinkedHashMap::new,
                        Collectors.averagingInt(Project::getDuration)));

        System.out.println(result);

    }
}