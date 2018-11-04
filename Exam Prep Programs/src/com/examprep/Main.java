package com.examprep;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<ImmutablePositionClass> allPositions = new ArrayList<ImmutablePositionClass>();
        ImmutablePositionClass p1 = new ImmutablePositionClass(1,2);
        ImmutablePositionClass p2 = new ImmutablePositionClass(100,200);
        allPositions.add(p1);
        allPositions.add(p2);
        GenericsExploration exploringGenerics = new GenericsExploration();
        exploringGenerics.printArray(allPositions);
        System.out.println(p1.compareTo(p2));
        System.out.println(p2.compareTo(p1));

    }
}
