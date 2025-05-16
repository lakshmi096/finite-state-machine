package com.machinecoding.driver;

import com.machinecoding.command.CommandProcessor;

import java.util.Scanner;

public class FSMDriver {
    public static void main(String[] args) {
        CommandProcessor processor = new CommandProcessor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter commands (type 'EXIT' to quit):");
        while (true) {
            String line = scanner.nextLine();
            if ("EXIT".equalsIgnoreCase(line.trim())) break;
            processor.process(line);
        }
        scanner.close();
    }
}
