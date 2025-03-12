package ComparatorInterface_Sorting;

import java.util.Comparator; //a
import java.util.function.Function; //c
import java.util.Arrays;

/*

This program defines a comparator class by implementing the Comparator interface (lines provided below).
  public static class MyComparator implements
      java.util.Comparator<String>

The compare method is implemented to compare two strings by their lengths.
public int compare(String s1, String s2) {
      return s1.length() - s2.length();
    }
The program invokes the sort method to sort an array of strings using a comparator.
   java.util.Arrays.sort(cities, new MyComparator());

Since Comparator is a functional interface, the code can be simplified using a lambda
expression as follows:

java.util.Arrays.sort(cities,
(s1,s2) -> {return s1.length() - s2.length();});

or:
java.util.Arrays.sort(cities,
(s1,s2) -> s1.length() - s2.length());

    Arrays.sort can take a custom comparator to change the sorting logic.
    compare defines the sorting rule (here, sorting by string length).
    The comparator subtracts string lengths to determine order.
    Alternative: Instead of a separate class, you can use a lambda expression for a shorter version:
    java
    Copy
    Edit
    java.util.Arrays.sort(cities, (s1, s2) -> s1.length() - s2.length());

-----------------COMPARABLE VS COMPARATOR------------------------------
EXAMPLES PROVIDED BELOW PROGRAM

In Java, the Comparable and Comparator interfaces are both used to define custom sorting logic, but they serve different purposes.
The Comparable<T> interface is used when a class naturally has a single way it should be sorted. It requires implementing the
compareTo method within the class itself. In contrast, the Comparator<T> interface is used when sorting needs to be defined
externally, allowing for multiple sorting strategies without modifying the class. Comparable is more specific when an object has
a single natural order, while Comparator provides flexibility for custom sorting.
 */

public class SortStringByLength {
    public static void main(String[] args) {
        String[] cities = {"Atlanta", "Savannah", "New York", "Dallas"};

        // (a) Sorting using MyComparator (inner class)
        Arrays.sort(cities, new MyComparator());
        System.out.println("Sorted using MyComparator:");
        System.out.println(Arrays.toString(cities) + "\n");

        // (b) Sorting using Comparator.comparing(String::length)
        Arrays.sort(cities, Comparator.comparing(String::length));
        System.out.println("Sorted using Comparator.comparing(String::length):");
        System.out.println(Arrays.toString(cities) + "\n");

        // (c) Sorting using an anonymous Function implementation
        Arrays.sort(cities, Comparator.comparing(
                new Function<String, Integer>() {
                    public Integer apply(String s) {
                        return s.length();
                    }
                }
        ));
        System.out.println("Sorted using an anonymous Function implementation:");
        System.out.println(Arrays.toString(cities) + "\n");

        // (d) Sorting using custom comparing method
        Arrays.sort(cities, comparing(String::length));
        System.out.println("Sorted using custom comparing method:");
        System.out.println(Arrays.toString(cities));
    }

    // Inner class comparator
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }

    // Custom comparing method (similar to Comparator.comparing)
    public static Comparator<String> comparing(Function<String, Integer> f) {
        return (s1, s2) -> f.apply(s1).compareTo(f.apply(s2));
    }
}



/*
....Example: Using Comparable (Single Natural Order)
class Product implements Comparable<Product> {
    int price;

    public Product(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.price, other.price); // Sort by price
    }
}
* The compareTo method inside Product defines its natural sorting order (by price).
* You can sort a List<Product> directly with Collections.sort(products).

....Example: Using Comparator (Custom Sorting)

import java.util.Comparator;

class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Integer.compare(p2.price, p1.price); // Descending order
    }
}
*/
