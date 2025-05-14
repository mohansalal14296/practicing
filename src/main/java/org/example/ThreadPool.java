package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final WorkerThread[] workers;
    private volatile boolean isStopped = false;

    public ThreadPool(int numThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new WorkerThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            workers[i] = new WorkerThread(taskQueue);
            workers[i].start();
        }
    }

    public void submitTask(Runnable task) {
        if (isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        taskQueue.offer(task);
    }

    public void stop() {
        isStopped = true;
        for (WorkerThread worker : workers) {
            worker.stopWorker();
        }
    }

    private static class WorkerThread extends Thread {
        private final BlockingQueue<Runnable> taskQueue;
        private volatile boolean isStopped = false;

        public WorkerThread(BlockingQueue<Runnable> taskQueue) {
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void stopWorker() {
            isStopped = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3);

        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            threadPool.submitTask(() -> {
                System.out.println("Executing task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Add a delay to allow all tasks to complete
        try {
            Thread.sleep(11000); // Wait for all tasks to finish (10 tasks * 1 second each)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}