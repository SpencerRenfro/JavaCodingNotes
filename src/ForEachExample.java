import java.util.Iterator;
import java.util.*;

/*
* 2. Enhanced For-Each Loops in Java
The enhanced for-each loop (for-each loop) is used to iterate
* over arrays and collections without using an index or explicit iterators.

Syntax
for (Type variable : collection) {
    // Code to execute
}*/



// Custom class implementing Iterable
class MyCollection implements Iterable<String> {
    private String[] data = {"Apple", "Banana", "Cherry"};

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.length;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return data[index++];
            }
        };
    }
}



class JavaEightSyntax {
    public void useForEach() {
        Collection<String> collection = new ArrayList<>();
        collection.add("New York");
        collection.add("Atlanta");
        collection.add("Dallas");
        collection.add("Madison");

        // Using Java 8 forEach with a lambda expression
        collection.forEach(e -> System.out.print(e.toUpperCase() + " "));
        System.out.println(); // Newline for formatting
    }
}


/*
* Static class example public class ForEachExample {
    // Nested static class
    public static class JavaEightSyntax {
        public static void useForEach() {
            Collection<String> collection = new ArrayList<>();
            collection.add("New York");
            collection.add("Atlanta");
            collection.add("Dallas");
            collection.add("Madison");

            // Using Java 8 forEach method with a lambda expression
            collection.forEach(e -> System.out.print(e.toUpperCase() + " "));
            System.out.println(); // Newline for formatting
        }
    }
    *
    * call inside main
    *  JavaEightSyntax.useForEach();
* */
// Main class with the entry point
public class ForEachExample {
    public static void main(String[] args) {
        System.out.println("ForEachExample");
        MyCollection myCollection = new MyCollection();

        // Using enhanced for-each loop with Iterable
        for (String item : myCollection) {
            System.out.println(item);
        }

        // calling new java8syntax
        JavaEightSyntax javaEightSyntax = new JavaEightSyntax();
        javaEightSyntax.useForEach();

        //-----------------CODING PRACTICE ------------------
        // Suppose each element in list is a StringBuilder, write a statement using a forEach method to change the first character to uppercase for each element in list.

        // Defining list as List<Object> to require casting inside forEach
        List<Object> list = new ArrayList<>();
        list.add(new StringBuilder("spencer"));
        list.add(new StringBuilder("olyvia"));
        list.add(new StringBuilder("cindy"));
        list.forEach(e -> {
            if (((StringBuilder)e).length() > 0) {
                char ch = ((StringBuilder)e).charAt(0);
                if (Character.isLowerCase(ch)) {
                    ((StringBuilder)e).setCharAt(0, Character.toUpperCase(ch));
                };
            };
            System.out.println(e);
        });
    }
}
