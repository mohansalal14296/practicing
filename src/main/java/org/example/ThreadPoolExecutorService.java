package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorService {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            threadPool.submit(() -> {
                System.out.println("Executing task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown the thread pool after all tasks are submitted
        threadPool.shutdown();
    }
}