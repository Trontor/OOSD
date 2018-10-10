# Workshop 9

## 1) Tutorial

### 1.1 Test Review

1. What does an *association* represent on a UML diagram?

   It represents a 'has a' relationship between two objects.

2. Explain what the keyword *super* is/does.

   The `super` keyword calls the parents constructor.

3. Explain the different relationships represented by inheritance and interfaces, and when you would use them.

   #### Inheritance 

   An inheritance relationship describes a parent class -> subclass relationship, where the subclass inherits all the `protected` and `public` fields and methods of the parent class. You would use inheritance when you would like to extend the functionality of the parent class. 

   #### Interfaces

   An interface specifies a contract with the classes that wish to implement it. Such a contract means that the implementing classes must specify the body of the methods that the interface contains. You would use this when you need certain functionality to always be present within a class, which greatly assists with polymorphism. It can be thought of as a 'standard' for the code that wishes to mimic a specific functionality.

4. Explain the difference between a static and non-static (instance) variable, and when you would use them.

   #### Static Variable

   A static variable is a variable that is shared amongst all classes of the same type. That is, when the variable updates in one class then it retains the updated value between all other classes instantiated of the same type. One such simple use case is a counter.

   #### Instance Variable

   An instance variable is unique to each class, even to multiple classes of the same type. You would use this when you need to maintain separate and unique values to variables across classes. 

