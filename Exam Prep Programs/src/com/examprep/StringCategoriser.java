package com.examprep;

public class StringCategoriser implements Categoriser<String,String> {
  public String categorise(String input){
    return String.valueOf(input.charAt(0));
  }
}
