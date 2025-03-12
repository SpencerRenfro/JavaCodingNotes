package ComparatorInterface_Sorting;

import java.util.Arrays;


public class Sort2DArray {
    public static void main(String[] args) {
        // Define a 2D array of doubles
        double[][] x = {
                {3, 1},
                {2, -1},
                {2, 0}
        };

        // Print the original array
        System.out.println("Original Array:");
        print2DArray(x);

        // Sort the array based on the second column (index 1)

        Arrays.sort(x, (e1, e2) -> Double.compare(e1[1], e2[1]));

        // using a ternay operator
     //   Arrays.sort(x, (e1, e2) -> (e1[1] < e2[1]) ? -1 : (e1[1] == e2[1] ? 0 : 1));

        //sorting by second column as the primary order and first column as the secondary order
        Arrays.sort(x, (e1, e2) -> {
                    if (e1[1] - e2[1] != 0)
                        return (e1[1] < e2[1]) ? -1 : ((e1[1] == e2[1]) ? 0 : 1);
                        // or  return Double.compare(e1[1], e2[1]);
                    else
                        return (e1[0] < e2[0]) ? -1 : ((e1[0] == e2[0]) ? 0 : 1);

        });


        // Print the sorted array
        System.out.println("\nSorted Array (Increasing order of second column):");
        print2DArray(x);
    }

    // Method to print a 2D array
    private static void print2DArray(double[][] array) {
        for (double[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}