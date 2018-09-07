# Sample Mid Semester Test

## Question 1

### (a) Define the keywords `final` and `static`

`final` 

- Declares a method or variable as immutable. 
- i.e. once it is assigned/instantiated it cannot be reassigned/instantiated

### (b) What does it mean for a class to be immutable?

When a class is immutable, it means that its value and attributes cannot change once it is initialized.  We choose to make classes immutable if it makes no sense to be able to change the value, or to prevent unwanted modification during the runtime of the application. Immutable objects are also thread-safe.

### (c) When methods and variables have no privacy modifier, what visibility do they have and where can they be accessed?

They are visible to and only can be accessed in the same package (project).

### (d) Define an instance variable called `parent` of type `Person` with initial value `null`

`Person parent = null;`

OR

`Person parent;`

### (e) Write one line of code to print `animal` and array of `Animal` objects.

```java
System.out.println(Arrays.toString(animals));
```

## Question 2 - Develop

In this question we will step you through implementing classes and methods in Java for a new
ride-sharing app called Rebu. Rebu connects passengers looking for a ride with drivers in their area.

You can assume that the classes or methods in earlier questions “exist” in later questions, even if
you haven’t answered the question. You must follow proper Object Oriented Design principles, and
Java programming conventions.

Write all class declarations. Do not write method signatures that are given to you.

### (a) Implement an immutable `Position` class. A `Position` is defined by its `x` and `y` coordinate. Your class should include a constructor, and appropriate getters and setters. 

```java
public final class Position {
    private final float x, y;
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public Position(float x, float y){
        this.x = x;
        this.y = y;
    }
}
```

### (b) Implement the `double distance(Position other)` method (Euclidean Distance)

*Note: The `Math` package is imported by default in Java*

```java
double distance(Position other) {
    float deltaX = other.getX() - x;
    float deltaY = other.getY() - y;
    return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
}
```

### (c) Implement a User class which represents both `passengers` and `drivers`. A `User` is defined by their `location` in the world.

*Note: psst take the hint, a **user represents two things!***

A thing to note here is that since we've made `Position` immutable, getters are not *really* necessary, but since it is the appropriate convention we'll use it here.

```java
public abstract class User{
    private Position pos;
    public Position getPos(){
        return pos;
    }
    public User(Position position){
        this.pos = position;
    }
    public String toString(){
        return String.format("(%f, %f)", pos.getX(), pos.getY());
    }
}
```

