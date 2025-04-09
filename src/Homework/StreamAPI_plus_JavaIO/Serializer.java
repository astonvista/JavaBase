package Homework.StreamAPI_plus_JavaIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;


//Класс для сериализации объекта или объектов из коллекции.
public class Serializer {

    public static void serialize(Serializable object, String fileName) {
        try (ObjectOutputStream writer =
                     new ObjectOutputStream(
                             new FileOutputStream(fileName + ".txt"))) {
            writer.writeObject(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static <Serializable> void serialize(List<Serializable> list, String baseFileName) {
        for (int i = 0; i < list.size() - 1; i++) {
            try (ObjectOutputStream writer =
                         new ObjectOutputStream(
                                 new FileOutputStream(baseFileName + i + ".txt"))) {
                writer.writeObject(list.get(i));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
