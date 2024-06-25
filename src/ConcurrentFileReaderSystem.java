package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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

//using Future

class ConcurrentFileSystemWithFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<String> pathList = List.of("/Users/HP/Desktop/file1.txt",
                "/Users/HP/Desktop/file2.txt",
                "/Users/HP/Desktop/file3.txt");

        List<Future<String>> futures = new ArrayList<>();

        for (String filePath : pathList) {
            Future<String> future = executorService.submit(() -> readFile(filePath));
            System.out.println(future);
            futures.add(future);
        }

        for (Future<String> future : futures) {
            try {
                while (!future.isDone()) {
                    Thread.sleep(5000);
                    System.out.println("Future is not done");
                }
                String content = future.get();
                System.out.println("File Content " + content);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Thread.sleep(5000);
                content.append(line).append("\n");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }
}

//using Completeable Future
class ConcurrentFileSystemWithCompleteableFuture {
    public static void main(String[] args) {
        List<String> pathList = List.of("/Users/HP/Desktop/file1.txt",
                "/Users/HP/Desktop/file2.txt",
                "/Users/HP/Desktop/file3.txt");

        List<CompletableFuture<String>> completableFutures = pathList.stream().
                map(filepath -> CompletableFuture.supplyAsync(() -> readFile(filepath)))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures
                .toArray(new CompletableFuture[0]));

        allFutures.thenAccept(res -> {
            for (CompletableFuture<String> future : completableFutures) {
                try {
                    String content = future.get();
                    System.out.println("File Content: " + content);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Math thread started to execite " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Thread.sleep(1000);
                content.append(line).append("\n");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }
}
