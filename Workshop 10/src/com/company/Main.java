package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(null);
        test.add(2);
        System.out.format("There are %d non-null elements in the first test array.\n", countValidElements(test.toArray()));

        List<Integer> test2 = new ArrayList<>();
        test2.add(3);
        test2.add(1);
        test2.add(2);
        MinMaxList minMaxTest = new MinMaxList(test2);
        System.out.format("Using MinMaxList, the minimum = %d, and maximum is %d\n", minMaxTest.getMin(), minMaxTest.getMax());


        HashMap<String, Class> test3 = new HashMap<>();
        test3.put("Integer", Integer.class);
        test3.put("String", String.class);
        test3.put("Double", Double.class);
        System.out.print("Please enter the type you want to make your elements: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Class selected = test3.get(input);
        System.out.format("You have chosen type %s, please enter in your values:\n", input);
        MinMaxList list = new MinMaxList<selected>();
        while (sc.hasNextLine()){
            list.add(sc.nextLine());
        }

    }

    public static <T> int countValidElements(T[] elements) {
        int counter = 0;
        for (T element : elements) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }

}
