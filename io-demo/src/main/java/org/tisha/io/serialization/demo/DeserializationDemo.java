package org.tisha.io.serialization.demo;

import org.tisha.io.serialization.entity.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Tsikhan Kuprevich
 * @since 8/8/2017
 */
public class DeserializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path currentRelativePath = Paths.get("");
        String base = currentRelativePath.toAbsolutePath().toString();

        try (FileInputStream fileInputStream = new FileInputStream(base + "/io-demo/src/main/resources/Emp.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Object o = objectInputStream.readObject();
            if (Employee.class.equals(o.getClass())) {
                System.out.println("Employee deserialized." + o);
            } else {
                System.out.println("Error: Employee has not been deserialized.");
            }

        }
    }
}
