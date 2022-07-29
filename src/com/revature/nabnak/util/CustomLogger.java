package com.revature.nabnak.util;

import java.io.*;
import java.time.LocalDateTime;

// TODO: IMPLEMENT ME!!!!
public final class CustomLogger {

    private static File logFile;
    private static FileWriter fileWriter;
    private static boolean loggerRunning = false;

    public static void openLogger() {

        if (loggerRunning) {
            System.out.println("The logger is already running");
        } else {
            try {
                logFile = new File("resources/log.txt");
                fileWriter = new FileWriter(logFile, true);
                loggerRunning = true;
                logToFile("Log Start");
            } catch (IOException e) {
                System.out.println("Logger failed to initialize");
                e.printStackTrace();
            }
        }
    }

    public static void closeLogger() {

        if (!loggerRunning) {
            System.out.println("The logger is already closed");
        } else {
            try {
                logToFile("Log End");
                fileWriter.close();
                loggerRunning = false;
            } catch (IOException e) {
                System.out.println("Logger failed to close");
                logToFile(e);
            }
        }
    }

    public static void logToFile(String message) {
        try {
            fileWriter.write(currentTime() + message);
        } catch (IOException e){
            System.out.println("Logger failed to log message");
            logToFile(e);
        }
    }

    public static void logToFile(Exception e) {

        try {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));

            fileWriter.write(currentTime() + sw);
            sw.close();
        } catch (IOException ee) {
            System.out.println("Logger failed to log Exception");
            ee.printStackTrace();
        }
    }

    // TODO: Implement this function
    private static String currentTime() {
        return "\n[" + LocalDateTime.now() + "]: ";
    }
}
