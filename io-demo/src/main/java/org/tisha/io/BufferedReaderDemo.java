package org.tisha.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * @author Tsikhan Kuprevich
 * @since 8/8/2017
 */
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {

        Path currentRelativePath = Paths.get("");
        String base = currentRelativePath.toAbsolutePath().toString();

        //JVM will auto close what's in the resource block. No need for finally block
        try (FileReader fr = new FileReader(base + "/io-demo/src/main/resources/my-file.txt");
             BufferedReader br = new BufferedReader(fr);) {

            int count = 0;
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    System.out.println(st.nextToken());
                    count++;
                }
            }
            System.out.println("Number of words in the file is : " + count);
        }
    }
}
