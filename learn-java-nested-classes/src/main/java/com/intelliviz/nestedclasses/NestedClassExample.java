package com.intelliviz.nestedclasses;

public class NestedClassExample {
    public class InnerNonStaticClass {
        public void display() {
            System.out.println("I'm in a non-static class");
        }
    }

    // only a nested inner class can be made private
    private class PrivateInnerNonStaticClass {
        public void display() {
            System.out.println("I'm in a private non-static inner class");
        }
    }

    public static class InnerStaticClass {
        public void display() {
            System.out.println("I'm in a static nested class");
        }
    }

    public void display() {
        System.out.println("I'm in the outer class");
    }

    // only the outer class can access a private inner class
    public void displayPrivate() {
        PrivateInnerNonStaticClass pinsc = new PrivateInnerNonStaticClass();
        pinsc.display();
    }
}
