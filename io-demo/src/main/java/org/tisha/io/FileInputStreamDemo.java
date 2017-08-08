package org.tisha.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Tsikhan Kuprevich
 * @since 8/8/2017
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {

        Path currentRelativePath = Paths.get("");
        String base = currentRelativePath.toAbsolutePath().toString();


        FileInputStream fis = null;
        try {

            fis = new FileInputStream(new File(base + "/io-demo/src/main/resources/my-file.txt"));
            System.out.println("File opened");

            int i;
            while ((i = fis.read()) != -1) {
                System.out.println((char) i + " | " + Integer.toBinaryString(i) + " | " + Integer.toString(100, 2) + " | " + i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
