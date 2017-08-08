package org.tisha.io.serialization.demo;

import org.tisha.io.serialization.entity.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Tsikhan Kuprevich
 * @since 8/8/2017
 */
public class SerializationDemo {
    public static void main(String[] args) throws IOException {

        Path currentRelativePath = Paths.get("");
        String base = currentRelativePath.toAbsolutePath().toString();

        try (FileOutputStream fileOutputStream = new FileOutputStream(base + "/io-demo/src/main/resources/Emp.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            Employee employee = new Employee(1, "John", 100000, 123145);
            objectOutputStream.writeObject(employee);
            System.out.println("Employee object serialized");

        }

    }
}
