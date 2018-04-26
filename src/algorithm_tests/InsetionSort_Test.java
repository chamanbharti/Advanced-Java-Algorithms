package algorithm_tests;

import algorithms.Sorting_algorithms;

import java.util.Scanner;

public class InsetionSort_Test {
    final static int MAX_NUMBERS = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[MAX_NUMBERS];
        System.out.printf("Type up to %d numbers followed by 0: ", MAX_NUMBERS);
        int n = 0;
        int v = input.nextInt();
        while (v != 0 && n < MAX_NUMBERS) {
            num[n++] = v;
            v = input.nextInt();
        }
        if (v != 0) {
            System.out.printf("\nMore than %d numbers enterd\n", MAX_NUMBERS);
            System.out.printf("First %d used\n", MAX_NUMBERS);
        }
        if (n == 0) {
            System.out.printf("\nNo numbers supplied\n");
            System.exit(1);
        }
        int num_comp = Sorting_algorithms.insertion_sort_comparison_counts(num, 0, num.length-1);
        System.out.print("\nThe sorted numbers are: ");
        for (v = 0; v < n; v++)
            System.out.printf("%d ", num[v]);
        System.out.println();
        System.out.println("Number of comparisons: " + num_comp);
    }

}
