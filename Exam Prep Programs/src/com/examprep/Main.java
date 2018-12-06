package com.examprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<ImmutablePositionClass> allPositions = new ArrayList<ImmutablePositionClass>();
    ImmutablePositionClass p1 = new ImmutablePositionClass(1, 2);
    ImmutablePositionClass p2 = new ImmutablePositionClass(100, 200);
    allPositions.add(p1);
    allPositions.add(p2);
    GenericsExploration exploringGenerics = new GenericsExploration();
    exploringGenerics.printArray(allPositions);
    System.out.println(p1.compareTo(p2));
    System.out.println(p2.compareTo(p1));

    CategorisedMap<String, String, StringCategoriser> categories
        = new CategorisedMap<>(new StringCategoriser());
    categories.put("Hulk");
    categories.put("Hawkeye");
    System.out.println(categories);
    System.out.println(categories.getCategoryCount("Hammerhead"));

    ArrayList<String> test123 = new ArrayList<>();
    test123.add("AbC");
    test123.replaceAll(String::toLowerCase);
    String s = "test".split(".")[1];
    System.out.println(test123.toString());
    HashMap<Integer, String> map = new HashMap<>();
    map.put(1, "One");
    HashMap<Integer,String> mapCopy = new HashMap<>();
    mapCopy.putAll(map);
    System.out.println(map.toString());
  }
}
