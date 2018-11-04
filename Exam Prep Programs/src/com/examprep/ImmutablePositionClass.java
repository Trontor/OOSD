package com.examprep;

/* These class names are not good in practicality */
public final class ImmutablePositionClass implements Comparable {
    private double xPos, yPos;

    public ImmutablePositionClass(double x, double y) {
        xPos = x;
        yPos = y;
    }

    public static double euclideanDistance(ImmutablePositionClass position) {
        return Math.sqrt(Math.pow(position.getX(), 2) + Math.pow(position.getY(), 2));
    }

    @Override
    public String toString() {
        return Double.toString(euclideanDistance(this));
    }

    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof ImmutablePositionClass)) {
            return -1;
        } else {
            double diff = (euclideanDistance(this) - euclideanDistance((ImmutablePositionClass) o));
            return (int) diff;
        }
    }
}
