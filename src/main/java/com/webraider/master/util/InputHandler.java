package com.webraider.master.util;

import com.webraider.master.styles.ConsoleColors;
import com.webraider.master.styles.ASCIIArtGallery;

import java.util.Scanner;

/*
@author Sma1lo
*/

public class InputHandler {

    private static String targetUrl;
    private static int numberOfThreads;
    private static int requestsPerThread;
    private static int delay;
    private static String requestMethod;
    private static String postData = "key1=value1&key2=value2";

    public static void handleInput(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            displayMenu(scanner);
        } catch (Exception e) {
            System.err.println(ConsoleColors.RED + "[ERROR]" + ConsoleColors.RESET + " Input error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void displayMenu(Scanner scanner) {
        int consoleWidth = 80;

        String[] messages = {
                "",
        };
        System.out.println(ASCIIArtGallery.WEB_RAIDER);
        System.out.println(centerMessage("1. Start WebRaider", consoleWidth));
        System.out.println(centerMessage("2. Authors", consoleWidth));
        System.out.println(centerMessage("0. Exit", consoleWidth));

        for (String message : messages) {
            System.out.println(centerMessage(message, consoleWidth));
        }
        System.out.print(centerMessage("Enter number:", consoleWidth));
                int choice = scanner.nextInt();
                scanner.nextLine();

            switch (choice) {
                case 1:

                    getInputFromUser(scanner);

                    if ("POST".equals(requestMethod)) {
                        System.out.println("POST Data: " + postData);
                    }

                    break;
                case 2:
                    System.out.println("Authors: Sma1lo_");
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "[ERROR]" + ConsoleColors.RESET + " Invalid choice.");
            }
    }
    public static String centerMessage(String message, int width) {
        int messageLength = message.length();
        int padding = (width - messageLength) / 2;
        StringBuilder centeredMessage = new StringBuilder();

        for (int i = 0; i < padding; i++) {
            centeredMessage.append(" ");
        }

        centeredMessage.append(message);

        return centeredMessage.toString();
    }

    private static void getInputFromUser(Scanner scanner) {
        System.out.print("Enter target URL: ");
        targetUrl = scanner.nextLine();

        System.out.print("Enter number of threads: ");
        numberOfThreads = scanner.nextInt();

        System.out.print("Enter number of requests per thread: ");
        requestsPerThread = scanner.nextInt();

        System.out.print("Enter delay between requests (ms): ");
        delay = scanner.nextInt();

        System.out.print("Enter HTTP method (GET/POST): ");
        requestMethod = scanner.next().toUpperCase();
        validateMethod(requestMethod);

        if ("POST".equals(requestMethod)) {
            System.out.print("Enter POST data (key1=value1&key2=value2): ");
            postData = scanner.next();
        }
    }

    private static void validateMethod(String method) {
        if (!"GET".equals(method) && !"POST".equals(method)) {
            System.err.println(ConsoleColors.RED + "[ERROR]" + ConsoleColors.RESET + " Invalid HTTP method. Use GET or POST.");
            System.exit(1);
        }
    }

    public static String getTargetUrl() {
        return targetUrl;
    }

    public static int getNumberOfThreads() {
        return numberOfThreads;
    }

    public static int getRequestsPerThread() {
        return requestsPerThread;
    }

    public static int getDelay() {
        return delay;
    }

    public static String getRequestMethod() {
        return requestMethod;
    }

    public static String getPostData() {
        return postData;
    }
}