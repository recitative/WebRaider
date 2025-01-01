package com.webraider.master.util;

import com.webraider.master.http.HttpRequestHandler;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
@author sma1lo
*/

public class ThreadManager {
    public static final String RESET = "\u001B[0m";

    public static final String RED = "\u001B[31m";

    public static void executeRequests(int numberOfThreads, int requestsPerThread, int delay, String requestMethod, String postData, AtomicInteger successCount) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(() -> performRequests(requestsPerThread, delay, requestMethod, postData, successCount));
        }

        shutdownExecutor(executor);
    }

    private static void performRequests(int requestsPerThread, int delay, String requestMethod, String postData, AtomicInteger successCount) {
        for (int j = 0; j < requestsPerThread; j++) {
            try {
                HttpRequestHandler.sendRequest(InputHandler.getTargetUrl(), requestMethod, postData);
                successCount.incrementAndGet();
            } catch (IOException e) {
                System.err.printf(RED + "[ERROR]" + RESET + " Request failed: %s%n", e.getMessage());
            }
            sleep(delay);
        }
    }

    private static void sleep(int delay) {
        try {
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(RED + "[ERROR]" + RESET + " Thread was interrupted during sleep: " + e.getMessage());
        }
    }

    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}