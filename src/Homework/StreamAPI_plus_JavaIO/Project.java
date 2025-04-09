package Homework.StreamAPI_plus_JavaIO;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


public class Project implements Serializable {
    private String name;
    private int duration;
    @Serial
    private static final long serialVersionUID = 1L;

    public Project(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public Project() {
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return getName() + " - Duration: " + getDuration();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(getName(), project.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
