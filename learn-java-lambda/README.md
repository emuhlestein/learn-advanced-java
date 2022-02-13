## Syntax of Lambda Expression
( input parameters ) -> { body }

An interface with one abstract method is a **Functional Interface**.

// This is a functional interface as it only has one abstract method.  
public interface Contruct  {  
&nbsp;&nbsp;&nbsp;public void build(); // this method is abstract.  
}

New annotation

// This is also a functional interface  
@FunctionalInterface  
public interface Contruct  {  
&nbsp;&nbsp;&nbsp;public void build(); // this method is abstract.  
}
