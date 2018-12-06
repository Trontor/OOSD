package com.examprep;

public interface Categoriser<In, Out>{
  Out categorise(In input);
}