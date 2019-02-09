package com.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private File file;
    private List<String> list = new ArrayList<>();

    public Controller() {
        this.file = new File();
    }

    public void menu() throws IOException {
        System.out.println("Enter the directory path: ");
        this.paramsList();
        System.out.println();
        System.out.println("Enter the file name extension: ");
        this.paramsList();
        System.out.println();
        System.out.println("Provide the old data stream to be changed: ");
        this.paramsList();
        System.out.println();
        System.out.println("Enter a new data stream to change: ");
        this.paramsList();
        System.out.println();

        file.change(file.search(list), list);
    }

    public List<String> paramsList() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str != null) {
            list.add(str);
        }
        return list;
    }
}
