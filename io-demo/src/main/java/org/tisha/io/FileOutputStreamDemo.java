package org.tisha.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Tsikhan Kuprevich
 * @since 8/8/2017
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        Path currentRelativePath = Paths.get("");
        String base = currentRelativePath.toAbsolutePath().toString();

        try {
            fileInputStream = new FileInputStream(base + "/io-demo/src/main/resources/dog.jpg");
            fileOutputStream = new FileOutputStream(base + "/io-demo/src/main/resources/dog_out.jpg");
            int data;
            while ((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }
            System.out.println("File Copied");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
