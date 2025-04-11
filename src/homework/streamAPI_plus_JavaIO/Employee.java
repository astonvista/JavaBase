package homework.streamAPI_plus_JavaIO;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Employee implements Serializable {
    private String name;
    private int age;
    private int salary;
    private List<Project> projects = new ArrayList<>();
    @Serial
    private static final long serialVersionUID = 1L;

    public Employee(String name, int age, int salary, List<Project> projects) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.projects = projects;
    }

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    }

    public void assignProject(Project project) {
        this.projects.add(project);
    }

    public void assignProject(List<Project> project) {
        this.projects.addAll(project);
    }

    @Override
    public String toString() {
        return "Employee: " + getName() + ", Age: " + getAge() + ", Salary: " + getSalary() +
                "\n" + "Projects: " + getProjects() + "\n";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public List<Project> getProjects() {
        return projects;
    }
}

