package org.example.main;

import org.example.linkedlist.ForEach;
import org.example.linkedlist.LinkedList;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.add("item " + i);
        }

        linkedList.forEach2((x) -> System.out.println("sara " + x));

    }
}