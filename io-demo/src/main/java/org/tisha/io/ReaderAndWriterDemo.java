package org.tisha.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Tsikhan Kuprevich
 * @since 8/8/2017
 */
public class ReaderAndWriterDemo {

    public static void main(String[] args) throws IOException {

        Path currentRelativePath = Paths.get("");
        String base = currentRelativePath.toAbsolutePath().toString();

        FileReader fr = new FileReader(base + "/io-demo/src/main/resources/my-file.txt");
        FileWriter fw = new FileWriter(base + "/io-demo/src/main/resources/new-file.txt");

        int ch = 0;

        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fr.close();
        fw.close();
    }
}
