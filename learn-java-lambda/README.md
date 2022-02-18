### Syntax of a Lambda Expression
( input parameters ) -> { body }

An interface with one abstract method is a **Functional Interface**.

// This is a functional interface as it only has one abstract method.  
public interface Construct  {  
&nbsp;&nbsp;&nbsp;public void build(); // this method is abstract.  
}

New annotation

// This is also a functional interface  
@FunctionalInterface  
public interface Construct  {  
&nbsp;&nbsp;&nbsp;public void build(); // this method is abstract.  
}

Lamdas implement Functional Interfaces

## Consumer Functional Interface
Is an operation that accepts a single input argument and returns no results.

Consumer<String> c = (String s) -> {System.out.println(s);};

Simpliefied:

Consumer<String> c = s -> System.out.println(s);

Input parameter does not need the type. The compiler can figure it out.
Input parameter does not need parenthesis as there is only one parameter.
The body does not need {} since there is only one statement.

Method andThen() is for chaining.

## BiConsumer Functional Interface
BiConsumer<String> c = (a,b) -> System.out.println(a*b);

