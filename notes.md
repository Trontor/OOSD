# Table of Contents
* [L01 - Introduction](#l01---introduction)
* [L02 - Strings](#l02---strings)
	* [Some Examples](#some-examples)
	* [Reserved Characters](#reserved-characters)
	* [Operations](#operations)
	* [Immutable!](#immutable!)
	* [Equality](#equality)
	* [Wrappers and Primitives](#wrappers-and-primitives)
	* [Boxing/Unboxing](#boxing/unboxing)
		* [Boxing](#boxing)
		* [Unboxing](#unboxing)
	* [Formatting](#formatting)
* [L03 - Input and Output (I/O)](#l03---input-and-output-i/o)
	* [Command Line Arguments](#command-line-arguments)
	* [Scanner](#scanner)
* [L04 - Arrays](#l04---arrays)
* [L05 - Files](#l05---files)
* [L06 - Methods](#l06---methods)
	* [Signature](#signature)
	* [Why tho?](#why-tho?)
	* [`static` keyword](#`static`-keyword)
	* [Scope](#scope)
	* [Mutation](#mutation)
	* [Overloading](#overloading)
* [L07 - Classes and Objects](#l07---classes-and-objects)
	* [Objects](#objects)
		* [Static vs Instance](#static-vs-instance)
	* [Null](#null)
	* [Instantiation and Member Access](#instantiation-and-member-access)
	* [Constructors](#constructors)
	* [Standard Methods](#standard-methods)
	* [Finalize](#finalize)
* [L08 - Privacy](#l08---privacy)
	* [Mutability](#mutability)
	* [Modifiers](#modifiers)
		* [Private](#private)
		* [Protected](#protected)
		* [Public](#public)
	* [Getters and Setters](#getters-and-setters)
	* [Privacy Leaks](#privacy-leaks)
	* [Immutability](#immutability)
* [L09 - Inheritance](#l09---inheritance)
# L01 - Introduction
[← Return to Index](#table-of-contents)


Yeah

# L02 - Strings
[← Return to Index](#table-of-contents)


*[Java Documentation]( https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)*

Strings store sequences of characters

## Some Examples

```java
String s1 = "This is a String";
String s2 = "This is " + "also a String";
```

Unlike Python, you can't use single quotes

## Reserved Characters

Characters like `"` are reserved (because you start and end a string with it)

You need to escape them if you want to use them in a string

```java
"Hit that, she a "FEFE"" /* error, compiler thinks string ends at the second " */
"Hit that, she a \"FEFE\"" /* good */
```

Other common reserved characters: `\n`, `\t`

## Operations

The addition operator `+` can concatenate the string representation of two *objects* (using the `toString()` method inherited by every class)

```java
int a = 1;
String s = "a = " + a; /* good */
```

Keep in mind:

```java
"1 + 1 = " + 1 + 1 /* equates to 1 + 1 = 11 */
"1 + 1 = " + (1 + 1) /* equates to 1 + 1 = 2 */
```

Operator precedence still holds

## Immutability

Strings are immutable; once created, they can’t be modified, only replaced. An important point to note here is that, while the `String` object is immutable, **its reference variable is not.** So that's why, in the above example, the reference was made to refer to a newly formed `String` object.

```java
String str = "knowledge";
String s = str; // assigns a new reference to the same string "knowledge"
str = str.concat(" base"); /* NEW string, prev one is lost cause no other references*/
```

As applications grow, *it's very common for String literals to occupy large area of memory, which can even cause redundancy.* So, in order to make Java more efficient, **the JVM sets aside a special area of memory called the "String constant pool".**

When the compiler sees a `String` literal, it looks for the `String` in the pool. If a match is found, the reference to the new literal is directed to the existing `String` and no new `String` object is created. The existing `String` simply has one more reference. Here comes the point of making `String`objects immutable:

In the `String` constant pool, a `String` object is likely to have one or many references. *If several references point to same String without even knowing it, it would be bad if one of the references modified that String value. That's why String objects are immutable.*

*[Source and further reading](https://stackoverflow.com/questions/8798403/string-is-immutable-what-exactly-is-the-meaning)*

The String class is marked **final** so that nobody can override the behaviour of its methods.

## Equality

All classes in Java are actually pointers, or references. To check equality between two objects we use the `equals` method inherited from the god of classes, `Object`.

```java
String s = "Hello";
String s2 = new String("Hello");
System.out.println(s.equals(s2));
```

## Wrappers and Primitives 

Java provides “wrapper” classes for primitives. Primitives are things you're familiar with such as:

`int`, `double`, `char`

To conform with the "Object Oriented Model" these procedural conventions are **wrapped up** in a class representing the primitive type. **Provides extra functionality for primitives**, at the expense of very very very slight computational efficiency.

![](images\primitive-wrappers.png)

Has some nice stuff, but parsing is the most used one by far:
```java
Integer.parseInt("10");
Double.parseDouble("3.141592");
Boolean.parseDouble("TruE");
```

## Boxing/Unboxing

### Boxing

The process of converting a primitive to its equivalent wrapper class

### Unboxing

The process of converting a primitive to its equivalent wrapper class

Just remember that primitives types are the OG and you're effectively '**boxing**' it up with OOP classes.

## Formatting

```java
System.out.format("%2$d %<05d %1$d %3$10s", 10, 22, "Hello");
/*"22 0002210 Hello"
```

![](images\formatting.png)

# L03 - Input and Output (I/O)
[← Return to Index](#table-of-contents)


## Command Line Arguments

Just like in C:

```java 
public static void main(String[] args)
```

args is a variable that stores command line arguments

```java
java MyProg Hello World 10

This fills the args variable with three elements, "Hello", "World" and "10"
For multiword Strings, remember to use quotes
Also note that "10" is a String, not an int
```

## Scanner

*[Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)*

`Scanner` is a class that allows for powerful input parsing.

```java
import java.util.Scanner;
Scanner scanner = new Scanner(System.in);
String s = scanner.nextLine();
boolean b = scanner.nextBoolean();
int i = scanner.nextInt();
double d = scanner.nextDouble();
```

# L04 - Arrays
[← Return to Index](#table-of-contents)


*[Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html)*

As simple as can be

```java
int[] ints1 = {10, 20, 30, 40};
int[] ints = new int[100];
String[] strings = new String[100];

int x = ints[0];
int x = ints[-1]; // Gives out of bounds error

import java.util.Arrays;

int[] n1 = {1, 2, 3};
int[] n2 = {1, 2, 3};
Arrays.equals(n1, n2);
Arrays.sort(n1);
System.out.println(Arrays.toString(n1));

```

Arrays are references! Manipulating one reference affects all references

# L05 - Files
[← Return to Index](#table-of-contents)


```java
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

try (PrintWriter pw = new PrintWriter(new FileWriter("test.txt"))) {
	pw.println("Hello World");
	pw.format("My least favourite device is %s and its price is $%d",
	"iPhone", 100000);
} catch (IOException e) {
	e.printStackTrace();
}

```

Not expected to remember exact code for exam, scaffolding provided.

# L06 - Methods
[← Return to Index](#table-of-contents)


## Signature

*The name of a method, and the number and type of its parameters*

```java
<privacy?> <static?> <return type> <method name>(<arguments>)
```

- public and static are default
- Every method needs a return type (`int`, `double[]`, `void`...)
- Methods can have zero or more arguments
- You must include the return statement if it is not `void`
- Must be defined in a class
- Represents the class performing an action

## Why tho?

- Prevents code **duplication**

- Improves **readability**
- Makes code **reusable** and **portable**
- Easier to **debug**
- Gives “important code” a useful **name**

## `static` keyword

- Indicates a **constant**, **variable**, or **method** exists without an object.
- In other words, you do not need to create a variable to use something
  defined as `static`

For example, the Math library has various **static** functions, take this for example:

```java
double x = Math.sqrt(10);
```

We didn't declare some "`math`" object, we used the method directly without creating an instance of the class.

Here is a **non-static** example:

```java
Scanner scanner = new Scanner(System.in);
String text = scanner.nextLine();
```

## Scope

- Defines when a constant, variable or method can be “seen”

## Mutation

- Remember that objects are pointers in Java
- When we pass objects to methods, we pass references
- References allow us to “mutate” objects, despite being in a different scope

## Overloading

- When methods share the same name, but differ in the number, or type of arguments in the method signature

#### Base Method

```java
void magicalComputation(int n)
```

#### Overloading

```java
void magicalComputation(double n)

void magicalComputation(int n1, int n2)

void magicalComputation(int n1, int n2, int n3)
```

# L07 - Classes and Objects
[← Return to Index](#table-of-contents)


- A “generalization” of a real world (or “problem world”) entity
  - A physical real world thing, like a student or book
  - A physical real world thing, like a student or book
  -  An even more abstract thing like a list or a string (data)
- Represents a template for things that have common properties
- Contains **attributes** and **methods**
- Defines a new **data type**

## Objects

- Refers to both an instance of a class and all classes in Java, because all classes inherit the *Object* class. Confusing? Yeah, but it's pretty simple
- **Object**: A specific, concrete example of a class

- **Instance**: An object that exists in your code

```java
<privacy> class <ClassName> {
	<variable declarations>
	<method declarations>
}
```

### Static vs Instance

#### Static Variable

A property or attribute that is **shared by all instances** of a class

```java
public class Movie {
	public static final int MAX_RATING = 5;
}
```

- One copy per class

#### Instance Variable

A property or attribute that is unique to each instance (object) of a class

```java
public class <ClassName> {
	public <type> varName = <value>;
}
```

- One copy per object

#### Static Method

An action that can be performed by a class, or a message that can be sent to it

```java
public class Movie {
	public static String getDefaultBlurb() {
		return "Better than Batman vs. Superman but that's not hard.";
    }
}
```

#### Instance Method

An action that can be performed by an object, or a message that can be sent to it

- Defines an action that can be performed by an object, or a message that can be sent to it

```java
public class Actor {
	public String firstName, lastName;
    
    public String getFullName() {
		return String.format("%s, %s", lastName, firstName);
	}
}
```

If a method doesn’t use any instance variables, it should be static.

## Null

- The Java keyword for **“no object here”**. Null objects **can’t be “accessed”** to get variables or methods, or used in any way.
- Objects are null until they are ***instantiated***.

- To instantiate an object we do:

  ```java
  Actor robertDowneyJr = new Actor();
  ```

## Instantiation and Member Access

- The `new` keyword tells the JVM to allocate memory for the object.

- The `.` operator 

```java
Actor robertDowneyJr = new Actor();
robertDowneyJr.firstName = "Robert";
robertDowneyJr.lastName = "Downey";
robertDowneyJr.rating = 5;
```

## Constructors

Constructors are methods used to initialize objects. They  have the same name of the class and cannot return any values. Classes can have more than one constructor (**overloading**).

*Constructor*: A method used to create and initialise an object.

```java
public Actor(String firstName, String lastName, int rating) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.rating = rating;
}

```

*Note:* The `this` keyword returns the current class that uses it

## Standard Methods

The god of all classes, **Object** contains these two methods:

```java
public String toString() {
	return <String>;
}

public boolean equals(<type> var) {
	return <boolean expression>;
}

```

That means that all classes (which inherit the *Object* class by default) have these methods and can ***override them*** to change their functionality.

## Finalize

```java
public void finalize() {
	<block of code to execute>
}
```

# L08 - Privacy
[← Return to Index](#table-of-contents)


## Mutability

- An object is mutable if any of its instance variables can be changed after being initialised.
- An object is immutable if none of its instance variables can be changed after being initialised.

**Information Hiding**: Using privacy to “hide” the details of a class from the
outside world.

## Modifiers

### Private

Only available to methods defined in the same class; should be applied to all (mutable) instance variables, and some methods.

### Protected

Available to all classes in the same package and also to any subclasses that inherit from the class.

### Public

Available at all times, everywhere.



![1535885278018](images\privacymodifiers.png)

## Getters and Setters

```java
public <type> get<VarName>() {
	return var;
}

public void set<VarName>(<type> var) {
	this.var = var;
}
```

**A class is immutable if all of its attributes are private, and it contains no setters.**

## Privacy Leaks

- When a reference to a private instance variable is made available to an external object, and unintended/unknown changes can be made.

## Immutability

- A class is immutable if all of its attributes are private, it contains no setters, and only returns copies of its (mutable) instance variables.

# L09 - Inheritance
[← Return to Index](#table-of-contents)

## Quick Reference

- Inheritance defines an “Is A” relationship
  - Rook is a piece
  - Dog is an animal 
  - Husky is a Dog
- Only use inheritance when this relationship makes sense

## Definition

A form of abstraction that permits “generalisation” of similar attributes/methods of classes; analogous to passing genetics on to your children.

## Superclasses

The “parent” or “base” class in the inheritance relationship; provides general information to its “child” classes.

## Subclass

The “child” or “derived” class in the inheritance relationship; inherits common attributes and methods from the “parent” class.

## Gist

**Ultimately allows code to be re-used**. Subclasses should be “more specific” versions of a superclass

## Example: Chess

This is **bad**:

```java
public class Board {
	private Pawn[] pawns;
	private Rook[] rooks;
	...
	private ???[][] board;
}

```

Instead, we create superclass called ***Piece***:

```java
public class Piece {
	public int row;
	public int col;
    public Piece(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public boolean isValidMove(int toRow, int toCol) {
		return true; // Dummy method, the piece type isn't known
	}
}
```

Each piece then can ***inherit*** this superclass, for example a chess piece known as the **Rook** can move in straight lines. This can be implemented by ***overriding*** the its parent `isValidMove` method:

```java
public class Rook extends Piece {
	public boolean isValidMove(int toRow, int toCol) {
		return (this.row == toRow) || (this.col == toCol);
	}
}
```

## Super Keyword

The `super` keyword invokes the constructor of the parent class.

```java
public class Rook extends Piece {
	public Rook(int row, int col) {
		super(row, col);
		<block of code to execute>
	}
}
```

`super` can also be used to reference an object's parent class; just like the `this` keyword.

## Shadowing

When two or more variables are declared with the same name in overlapping scopes; for example, in both a subclass and superclass.

**Don't do this**

## Overloading

Declaring multiple methods with the same name, but differing method signatures. Superclass methods can be overloaded in subclasses.

## Overriding

Declaring a method that exists in a superclass again in a subclass, with the same signature. Methods can only be overridden by subclasses.

### Why?

- Subclasses can extend functionality from a parent
- Subclasses can override/change functionality from a parent

Back to the chess example, we can use **overriding** to make a better implementation:

```java
public class Piece {
	public boolean isValidMove(int row, int col) {
		return row >= 0 && row < BOARD_SIZE &&
		col >= 0 && col < BOARD_SIZE;
	}
}
```

```java
public class Rook extends Piece {
	public boolean isValidMove(int row, int col) {
        return super.isValidMove(row, col) && ((this.row == row) || (this.col == col));
    }
}
```

If you don't want methods to be overridden use the `final` variable

# L10 - Polymorphism and Abstract Classes

## The Object Class

All classic inherit the object class. Two useful methods are exposed by the `Object` class:

- `toString`
- `equals`

That's great. We can override them to give them meaning.

```java
public static void main(String[] args) {
	Robot robot = new Robot();
    System.out.println(robot);
}
public String toString() {
	return String.format("Robot located at {%f, %f, %f}",
	this.x, this.y, this.z);
}
public boolean equals(Object other) {
    // check if references are the same
    if (this == other)
    	return true;
    // check if the object exists
    if (other == null)
    	return false;
    // type check before casting
    if (this.getClass() != other.getClass())
    	return false;
    Robot robot = (Robot) other;
    // field comparison
    return Math.abs(this.x - robot.x) < EPS && ...;
}
```

`"Robot located at {0, 0, 0}"` 	 

## `instanceof` Keyword

- Results in true if an object A is an instance of the same class as object B, or a class that inherits from B.

## Upcasting

When an object of a child class is assigned to a variable of an ancestor class.

` Robot robot = new AerialRobot();`

## Downcasting

When an object of an ancestor class is assigned to a variable of a child class. Only makes sense if the underlying object is actually of that class. Why?

```java
Robot robot = new WingedRobot();
WingedRobot plane = (WingedRobot) robot;
```

## Polymorphism

The ability to use objects or methods in many different ways; roughly means “multiple forms”.

![](C:\Users\rohyl\Documents\GitHub\OOSD\images\polymorphism.png)

## Abstract Methods

Some classes aren’t meant to be instantiated because they aren’t well defined. We use **abstract** classes to deal with this.

### Definition

Defines a method that is common to all subclasses, but has no implementation. Each subclass then provides it’s own implementation through overriding.

## Abstract Classes

Defines a class that is incomplete. Classes with abstract methods must be abstract, but abstract classes can have no abstract methods. Cannot be instantiated.

## Concrete Classes

- Classes that are not well defined



# L11 - Interfaces

Interfaces are **abstract classes** by default. They cannot contain instance ***variables***. They can contain only **constants** and **abstract methods**. The



# L12 - UML Handout