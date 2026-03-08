[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/5zph1elg)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23028675)

## Workshop 8 Interfaces and Packages

- The average duration to conclude this workshop is two hours. If you are not able to finish all the exercises in the workshop, you need spend more time on them. Make sure you always finish them without problems before the next workshop.

**CORRECTION!!! Please remove the lines `package workshop8;` from the code files provided**

### `Movable` interface

We will be implementing the following interface and classes as shown in the following UML diagram:

<img src="./movableInterface.png"> </img>

Some starter code files have been provided. 

Start by looking in file `Movable.java`. This contains the `Movaeble` interface. The first abstract method (as specified in the diagram) is already written.

**TASK** 

Add the other abstract methods as listed in the diagram.

Verify that the interface is valid by checking it compiles without error. 

```
javac Movable.java
```

Note that we do **not** run this file e.g. using `java Movable` as it is not executable. To be an executable filer it must contain a public `main` class definition.

Resources files such as `interface` and `class` files without a public `main` class will not produce any output, but the compiled code they contain can be used by other files (e.g. below we will write a file `TestApp.java` to test the classes we write).

### `MovablePoint` class

Next we will write a concrete class `MovablePoint` that implements the `Movable` interface.

You can see that the `MovablePoint` class contains the instance variables `x`, `y`, `xSpeed` and `ySpeed` with private-package access (or default access) as shown with `-` in the class diagram.

The `x` and `y` store the current co-ordinates, and the `xSpeed` and `ySpeed` store the increment by which the movable point changes position, each time a move is made (i.e. bigger speed values means that the poitn moves further for each step taken).

The starter code for the class can be found in `MovablePoint.java`. Complete the class definition by adding a suitable constructor with arguments (`x`, `y`, `xSpeed` and `ySpeed`) and implementing the `Movable` interface methods. You do not need to add getters or setters for the private attributes.

Add the `toString` method to print the object using format `MovablePoint[x=...,y=...,xSpeed=...,ySpeed=...]`

Test your code compiles without error:

```
javac MovablePoint.java
```

Write a program called `TestApp.java` as below with a public `main` method that tests your `MovablePoint` class. Check the output to see that your methods work properly i.e. that the position is updated as expected.

```java
public class TestApp {
   public static void main(String[] args) {
    Movable m1 = new MovablePoint(50, 60, 10, 15); // upcast
    System.out.println(m1);//equivilant to println(m1.toString())
    m1.moveLeft();
    m1.moverDown();
    System.out.println(m1);
```

### `MovablePoint` class

The `MovableCircle` class represents a circle that has a `MovablePoint` variable to represent its center. In other words, the `MovableCircle` composes a `MovablePoint`, and its radius.

The starter code for the class can be found in `MovableCircle.java`. Complete the class definition by adding a suitable constructor with arguments ( `x`, `y`, `xSpeed`, `ySpeed`, `radius`) and implementing the `Movable` interface methods so they act to update the `MovablePoint` that defines the centre of the circle correctly. 

Again you do not need to add getters or setters for the private attributes, but need to override the `toString()` method, to print out the detail information in the following format: `MovableCircle[center=MovablePoint[....],radius=...]`

Note that to access the `x` `y` attributes for the `MovablePoint` you can either add getters so that the `MovableCircle` can read this information from its `center` attribute, or build the `MovableCircle` `toString()` using the `MoveablePoint` public `toString()` method to get the details. 

Check that your class compiles using:

```
javac MovableCircle.java
```

Then add code to the bottom of your `TestApp.java` file to verify that the constructor, `toString()` and `Movable` methods work as expected.

```java
MovableCircle m2 = new MovableCircle(1, 2, 3, 4, 20); 
    System.out.println(m2);
    m2.moveRight();
    m2.moveUp();
    System.out.println(m2);
```

### Adding a second interface

Create a file `Shape.java` that stores a second interface that contains abstract methods for the area and perimeter of shapes.

```java
public interface Shape { 
  // Two abstract methods
  double area(); //implicitly public and abstract
  double perimeter(); //implicitly public and abstract
}
```

We want our `MovableCircle` class to also implement the `Shape` interface. To do this we first need to add the additional interface into the class definition, by changing it to:

```java
public class MovableCircle implements Movable, Shape {
    ...
}
```

When you have made this change check to see if the `MovableCircle.java` file compiles. You should find that it will cause an error, because although it states that the `MovableCircle` implements the `Shape` interface, it does not yet do so.

To fix this you must need to implement the abstract methods `area()` and `perimeter()` in `MovableCircle`.

When you have done this your `MovableCircle` class should compile without errors.

Add the following code to `TestApp.java`

```java
System.out.printf("Area:%.3f, Perimeter:%.3f%n",m2.area(),m2.perimeter());
```

### Polymorphism

Consider we may want to be able to use polymorphism to upcast our `MovableCircle` so that it is referenced as a `Movable`. Add the following to the end of `TestApp.java`:

```java
Movable m3 = new MovableCircle(0, 0, 5, 5, 20); // upcast
    System.out.println(m3);
    m3.moveRight();
    m3.moveUp();
    System.out.println(m3);
```

Run the file and check the output is as expected. Then add line:

```java
System.out.printf("Area:%.3f, Perimeter:%.3f%n",m3.area(),m3.perimeter());
```

You will find it causes an error! This is because `m3` has reference type `Movable` that does not implement a `area()` or `perimeter()` method.

We could try to fix it by changing `m3` to `Shape` reference type rather than `Movable` but if you try this you will find compilation errors when `m3` tries to use the `moveUp()` and `moveRight()` methods.

A preferable solution in this case might be to adjust our code structure so that the `Shape` interface extends the `Movable` interface, i.e. in terms of inheritance/implementation:

```
Shape extends Movable
```

```
MovableCircle implements Shape
```

Make these changes in your files. You should find that when you make this change you can upcast `m3` to a `Shape` and make use of both the `Shape` and `Movable` abstract methods.

### Organising your code with a package structure

We will now reorganise our code as a package. Before starting commit your working code to GitHub (in case you accidentally delete a file this means you can recover it!).


Next in your working folder create the following directories.

```
bin
build
doc
src
test
```

Make a sub-directory `shape` within the `src` directory. Move the `TestApp.java` file into the `test` directorym and the other `.java` files into the `src/shape` sub-directory. Delete the remaining `.class` files (you will regenerate these later).

This structure sets up our source code files to form the `shape` package. We need to declare this in each of our source code files in the `src/shape` director by adding the line:

```java
package shape;
```

Now that the code is specified as being in the `shape` package wwe also need to import the resources from this package in the `TestApp` program that makes use of them. Add the following to the `TestApp.java` file:

```java
import shape.*;
```

Our project code structure is now in place. With this structure the following steps can be used to compile the code, and run the test application:

To compile the package code use:

```
javac -d bin -cp bin src/shape/Movable.java
javac -d bin -cp bin src/shape/Shape.java
javac -d bin -cp bin src/shape/MovablePoint.java
javac -d bin -cp bin src/shape/MovableCircle.java
```

here:

**`-d bin`** means store the result in the `bin` directory.

**`-cp bin`** adds the `bin` directory to the class path in which resources may be found, e.g. the `Shape` interface extends the `Movable` interface and so will use `Movable.class` when it compiles.

Check the contents of the `bin` directory and you should find that the class files are collected in a `shape` subdirectory.

To compile the `TestApp.java` program (as this is not part of the package) we use:

```
javac -cp bin ./test/TestApp.java
```

The compiled program `TestApp.class` is kept within the `test` directory as it is not part of the `package`. 

We can run the `TestApp` program using:

```
java -cp bin:test TestApp
```

Here we need to specify that the class path to the program and its resources are in the `bin` and `test` directories.

### Making a jar file for distribution

To share a package it is convenient to collect all the necessary files into a single file which can be shared. Java allows us to do this by packaging files into a `.jar` file. In this case we can create it using the command:

```
jar cvf ./build/workshop8_v1_0.jar -C bin .
```

 `.` means store all files/folders in the current directory.

Here the `-c bin .` argument means store the contents of the `bin` folder in the top level of the `jar` file. It is a standard practice (I think...) to store the compiled binaries in this way, so that code that imports the package from the `jar` file finds it correctly.

Check that the `jar` file has been created in the `build` directory.

We can check the contents of the `jar` file using the command:

```
jar -tf ./build/workshop8_v1_0.jar
```

The jar file we have created can be used instead of the binaries when compiling and running code that makes use of the package it contains, e.g. we can run the `TestApp` program using:

```
java -cp ./build/workshop8_v1_0.jar:test TestApp
```

We can also add additional resources e.g. the source code and documentation into the `jar` file e.g. the following will add the contents of directories `src` and (currently empty) `doc`  to the `jar`:

```
jar -uvf ./build/workshop8_v1_0.jar src doc
```

Check the updated contents using:

```
jar -tf ./build/workshop8_v1_0.jar
```

This workshop is shorter than usual so that you can make a start on your pair programming coursework.
