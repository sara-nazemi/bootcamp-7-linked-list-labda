package org.example.main;

import org.example.linkedlist.ForEach;
import org.example.linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        linkedList.forEach2((x) -> System.out.println("sara " + x));

        List<Integer> filter2 = linkedList.filter((i) -> i % 2 == 0);
        //System.out.println(filter);

        List<Integer> integers = linkedList.filter2((i) -> i % 2 == 1);
        //System.out.println(integers);

        linkedList.map2((y) -> y + 2);


    }
}