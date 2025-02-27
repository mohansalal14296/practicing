package org.example;

import java.util.ArrayList;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("element2");
        myList.add("element3");

        myList.add(0, "element1");

        System.out.println(myList);
    }
}