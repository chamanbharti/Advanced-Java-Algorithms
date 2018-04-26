package algorithm_tests;

import algorithms.Sorting_algorithms;
import java.util.Scanner;

public class SelctionSort_Test {

    private final static int max_numbers = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[max_numbers];

        System.out.printf("Type up to %d numbers followed by 0: ", max_numbers);
        int n = 0;
        int v = input.nextInt();
        while (v != 0 && n < max_numbers) {
            num[n++] = v;
            v = input.nextInt();
        }
        if (v != 0) {
            System.out.printf("\nMore than %d numbers entered\n", max_numbers);
            System.out.printf("First %d used\n", max_numbers);
        }
        if (n == 0) {
            System.out.println("No numbers supplied\n");
            System.exit(1);
        }
        // n numbers are stored form num[0] to num[n-1]
        int comparison = Sorting_algorithms.selection_sort_count_comparison(num, 0, n-1);
        System.out.println("\nThe sorted numbers are\n");
        for (v = 0; v < n; v++)
            System.out.print(num[v] + " ");
        System.out.println("\n\nNumber of assignment: " + comparison);
    }
}
