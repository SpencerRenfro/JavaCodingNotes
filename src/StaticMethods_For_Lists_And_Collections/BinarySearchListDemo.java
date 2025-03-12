package StaticMethods_For_Lists_And_Collections;
//This method finds the index of a target element in a sorted list.
//Requirement: The list must be sorted in ascending order.
// Return Value: The index of the target element if it is found; otherwise, -(negative value).
import java.util.*;
public class BinarySearchListDemo {
    public static void main(String[] args) {
        List<Integer> list1 =
                Arrays.asList(2, 4, 7, 10, 11, 45, 50, 59, 60, 66);
        System.out.println("Binary Search Method");
        System.out.print("\nList1: ");
        list1.forEach(e -> System.out.print(e + " "));

        System.out.println("\n(1) 7 is at Index: " + Collections.binarySearch(list1, 7));
        System.out.println("(2) 9 is at Index: " + Collections.binarySearch(list1, 9));

        System.out.print("\nList2: ");
        List<String> list2 = Arrays.asList("blue", "green", "red");
        list2.forEach(e -> System.out.print(e + " "));
        System.out.println("\n(3) Red is at Index: " +
                Collections.binarySearch(list2, "red"));
        System.out.println("(4) Cyan is at Index: " +
                Collections.binarySearch(list2, "cyan"));


        ///  You can use the reverse method to reverse the elements in a list
        System.out.println("\nReversing Method");
        Collections.reverse(list2);
        System.out.println("\nList2 after reversing: ");
        System.out.println(list2);

        // You can use the shuffle method to shuffle the elements in a list
        System.out.println("\nShuffling Method");
        System.out.println("Original List2: ");
        System.out.println(list2);
        Collections.shuffle(list2);
        System.out.println("\nList2 after shuffling: ");
        System.out.println(list2);

        // You can also use the shuffle(list, random) method to shuffle the elements in a list using a specified random object
        List<String> listSeedShuffle1 = new ArrayList<>(Arrays.asList("black", "white", "gray", "cyan"));
        List<String> listSeedShuffle2 = new ArrayList<>(Arrays.asList("black", "white", "gray", "cyan"));
        System.out.print("\nShuffle method with seed 5\n");
        System.out.println("List1 original:" + listSeedShuffle1);
        System.out.println("List2 original:" + listSeedShuffle2);
        Collections.shuffle(listSeedShuffle1, new Random(5));
        Collections.shuffle(listSeedShuffle2, new Random(5));
        System.out.println("\nList1 after shuffling with seed 5: " + listSeedShuffle1);
        System.out.println("List2 after shuffling with seed 5: " + listSeedShuffle2);


        // You can use the fill method to fill all elements in a list with a specified value
        System.out.println("\nFilling Method");
        Collections.fill(list2, "black");
        System.out.println("\nList2 after filling with black: ");
        System.out.println(list2);

        // You can use the copy method to copy elements from one list to another
        System.out.println("\nCopy Method");
        List<String> list3 = new ArrayList<>(Arrays.asList("black", "white", "gray", "cyan"));
        List<String> list4 = new ArrayList<>(Arrays.asList("yellow","red"));
        System.out.println("List3 original: " + list3);
        System.out.println("List4 original: " + list4);
        Collections.copy(list3, list4);
        System.out.println("List3 after copying from List4: " + list3);

        // The disjoint method returns true if two specified collections have no elements in common
        System.out.println("\nDisjoint Method");
        List<String> list5 = new ArrayList<>(Arrays.asList("black", "white", "gray", "cyan"));
        List<String> list6 = new ArrayList<>(Arrays.asList("yellow","red"));
        System.out.println("List5: " + list5);
        System.out.println("List6: " + list6);
        System.out.println("Are List5 and List6 disjoint? " + Collections.disjoint(list5, list6));
        list6.add("black");
        System.out.println("List6 after adding black: " + list6);
        System.out.println("Are List5 and List6 disjoint? " + Collections.disjoint(list5, list6));

        // you can use nCopies(int n, Object o) method to create an immutable list that consists of n
        //copies of the specified object. For example the following code creates a list with fiver Calendar Objects:


        List<GregorianCalendar> calendarList1 = Collections.nCopies
                (5, new GregorianCalendar(2005, 0, 1));
        System.out.println("nCopies Method");
        System.out.println("\nList of 5 GregorianCalendar Objects: ");
        calendarList1.forEach(e -> System.out.println(e.getTime()));
        


    }
}