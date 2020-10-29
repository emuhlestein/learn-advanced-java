package com.intelliviz.nestedclasses;

public class LearnNestedClasses {
    public static void main(String[] args) {
        NestedClassExample nce = new NestedClassExample();
        nce.display();
        nce.displayPrivate();

        // An inner non-static class needs an instance of the outer class in order to be instantiated
        NestedClassExample.InnerNonStaticClass insc = nce.new InnerNonStaticClass();
        insc.display();

        // A static nested class does not need an instance of the outer class
        NestedClassExample.InnerStaticClass isc = new NestedClassExample.InnerStaticClass();
        isc.display();
    }
}
