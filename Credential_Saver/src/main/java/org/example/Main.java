package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Option.option();
        } catch (Exception e) {
            System.err.println("Failed to save credentials: " + e.getMessage());
        }
    }
}
