package ComparatorInterface_Sorting;

import java.util.Arrays;
import java.util.List;

public class SortStringIgnoreCase {
    public static void main(String[] args) {
        String[] cities = {"Atlanta", "Savannah", "New York", "Dallas"};
        java.util.Arrays.sort(cities, new MyComparator());
        System.out.println("cities1");
        for (String s : cities) {
            System.out.print(s + " ");
        }

        // or if cities were an ArrayList
        List<String> cities2 = Arrays.asList("Atlanta", "Savannah", "New York", "Dallas");
        cities2.sort(String::compareToIgnoreCase);

        System.out.println("cities2");
        for (String s : cities2) {
            System.out.print(s + " ");
        }

    }

    public static class MyComparator implements java.util.Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }
    }
}


