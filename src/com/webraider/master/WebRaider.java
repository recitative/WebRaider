package com.webraider.master;

import com.webraider.master.util.InputHandler;
import com.webraider.master.util.ThreadManager;

import java.util.concurrent.atomic.AtomicInteger;

/*
@author sma1lo
*/

public class WebRaider {
    private static String targetUrl;
    private static int numberOfThreads;
    private static int requestsPerThread;
    private static int delay;
    private static String requestMethod;
    private static String postData = "key1=value1&key2=value2";
    private static final AtomicInteger successCount = new AtomicInteger(0);

    public static final String RESET = "\u001B[0m";

    public static final String GREEN = "\u001B[32m";

    public static void main(String[] args) {

        InputHandler.handleInput(args);

        targetUrl = InputHandler.getTargetUrl();
        numberOfThreads = InputHandler.getNumberOfThreads();
        requestsPerThread = InputHandler.getRequestsPerThread();
        delay = InputHandler.getDelay();
        requestMethod = InputHandler.getRequestMethod();
        postData = InputHandler.getPostData();

        ThreadManager.executeRequests(numberOfThreads, requestsPerThread, delay, requestMethod, postData, successCount);

        System.out.println(GREEN + "[INFO]" + RESET + " All tasks completed.");
        System.out.printf(GREEN + "[INFO]" + RESET + " Total successful requests: %d%n", successCount.get());
    }
}