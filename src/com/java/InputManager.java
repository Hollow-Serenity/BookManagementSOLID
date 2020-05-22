package com.java;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputManager {

    private Scanner scanner;
    private PrintStream basicFeedback;
    private PrintStream errorFeedback;

    public InputManager(InputStream input, PrintStream basicFeedback, PrintStream errorFeedback) {
        this.basicFeedback = basicFeedback;
        this.errorFeedback = errorFeedback;
        scanner = new Scanner(input);
    }

    public long getInputLong(String message) {
        do {
            try {
                String data = getInputString(message);
                return Long.parseLong(data);
            } catch (NumberFormatException e) {
                errorFeedback.println("Please enter valid number");
            }
        } while (true);
    }

    public int getInputInt(String message) {
        do {
            try {
                String data = getInputString(message);
                return Integer.parseInt(data);
            } catch (NumberFormatException e) {
                errorFeedback.println("Please enter valid number");
            }
        } while (true);
    }

    public String getInputString(String message) {
        boolean ok = true;
        String input = "";
        do {
            try {
                basicFeedback.println(message);
                input = scanner.next();
                ok = false;
                return input;
            } catch (Exception e) {
                errorFeedback.println("Please enter valid data");
            }
        }
        while (ok);
        return input;
    }
}
