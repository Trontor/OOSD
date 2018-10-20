package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMaxList<T extends Comparable<T>> {
    private List<T> elements;
    public MinMaxList() {
        this.elements = new ArrayList<>();
    }
    public MinMaxList(List<T> input) {
        this.elements = input;
    }

    public void add(T element){
        elements.add(element);
    }

    public T getMin() {
        Collections.sort(elements);
        return elements.get(0);
    }

    public T getMax() {
        Collections.sort(elements);
        return elements.get(elements.size() - 1);
    }
}
