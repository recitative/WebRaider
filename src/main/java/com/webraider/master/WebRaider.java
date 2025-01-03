package com.webraider.master;

import com.webraider.master.util.InputHandler;
import com.webraider.master.util.ThreadManager;
import com.webraider.master.styles.ConsoleColors;

import java.util.concurrent.atomic.AtomicInteger;

/*
@author Sma1lo
*/

public class WebRaider {
    private static String targetUrl;
    private static int numberOfThreads;
    private static int requestsPerThread;
    private static int delay;
    private static String requestMethod;
    private static String postData = "key1=value1&key2=value2";
    private static final AtomicInteger successCount = new AtomicInteger(0);

    public static void main(String[] args) {

        try {
            InputHandler.handleInput(args);
            targetUrl = InputHandler.getTargetUrl();
            numberOfThreads = InputHandler.getNumberOfThreads();
            requestsPerThread = InputHandler.getRequestsPerThread();
            delay = InputHandler.getDelay();
            requestMethod = InputHandler.getRequestMethod();
            postData = InputHandler.getPostData();

            ThreadManager.executeRequests(numberOfThreads, requestsPerThread, delay, requestMethod, postData, successCount);

            System.out.println(ConsoleColors.GREEN + "[INFO]" + ConsoleColors.RESET + " All tasks completed.");
            System.out.printf(ConsoleColors.GREEN + "[INFO]" + ConsoleColors.RESET + " Total successful requests: %d%n", successCount.get());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}