package com.examprep;

import java.util.ArrayList;

/* These class names are not good in practicality */
public final class ImmutablePositionClass implements Comparable<ImmutablePositionClass> {

  private static final ImmutablePositionClass ORIGIN = new ImmutablePositionClass(0, 0);
  private double xPos, yPos;

  public ImmutablePositionClass(double x, double y) {
    xPos = x;
    yPos = y;

  }

  public static double euclideanDistance(ImmutablePositionClass p1, ImmutablePositionClass p2) {
    return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
  }

  @Override
  public String toString() {
    return Double.toString(euclideanDistance(this, new ImmutablePositionClass(0, 0)));
  }

  public double getX() {
    return xPos;
  }

  public double getY() {
    return yPos;
  }

  @Override
  public int compareTo(ImmutablePositionClass o) {
    double diff = (euclideanDistance(this, ORIGIN) - euclideanDistance(o, ORIGIN));
    return (int) diff;
  }
}
