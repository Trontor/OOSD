package com.examprep;

import java.util.ArrayList;
import java.util.HashMap;

public class CategorisedMap<K, V, C extends Categoriser<V, K>> {

  private HashMap<K, ArrayList<V>> map;
  private C categoriser;

  public CategorisedMap(C categoriser) {
    this.map = new HashMap<>();
    this.categoriser = categoriser;
  }

  public void put(V value) {
    K cat = categoriser.categorise(value);
    if (!map.containsKey(cat)) {
      ArrayList<V> newList = new ArrayList<>();
      newList.add(value);
      map.put(cat, newList);
    } else {
      map.get(cat).add(value);
    }
  }

  public int getCategoryCount(V value) {
    K cat = categoriser.categorise(value);
    ArrayList<V> list = map.get(cat);
    return list == null ? 0 : list.size();
  }

  public String toString(){
    String output = "";
    for (K key : map.keySet()){
      output += key.toString() + ": ";
      for (V val : map.get(key)){
        output += val.toString() + ", ";
      }
      output += "\n";
    }
    return output;
  }

}
