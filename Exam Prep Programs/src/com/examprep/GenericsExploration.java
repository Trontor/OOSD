package com.examprep;

import java.util.ArrayList;
import java.util.List;

/* we begin a generics class by declaring the classname post-fixed with <T> where T can be any letter */
/* an extra condition has been made on the generic type, it must implement Comparable<T> if it is to be used */
public class GenericsExploration<T extends Comparable<T>> {
    /* sets all elements of a given array to null */
    public void nukeArray(T[] inputArray){
        for (int i = 0; i < inputArray.length; i++){
            inputArray[i] = null; /* >:) */
        }
    }

    /* just because */
    private String genericPrint(T obj){
        return String.format("[Generic Print] %s", obj.toString());
    }

    /* print all elements of an array */
    public void printArray(List<T> elements){
        for (T element : elements){
            System.out.println(genericPrint(element));
        }
    }

}
