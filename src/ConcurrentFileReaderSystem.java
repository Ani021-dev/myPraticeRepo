package src;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentFileReaderSystem {
    public static void main(String[] args) {
        String[] filePath = {
                "/Users/HP/Desktop/file1.txt",
                "/Users/HP/Desktop/file2.txt",
                "/Users/HP/Desktop/file3.txt"
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (String path : filePath) {
            executorService.execute(() -> readFile(path));
        }

        executorService.shutdown();

    }

    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": reads line " + line);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
