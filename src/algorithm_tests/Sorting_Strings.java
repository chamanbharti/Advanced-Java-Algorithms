
package algorithm_tests;

import algorithms.Sorting_algorithms;

public class Sorting_Strings {

    final static int MAX_NAMES = 8;

    public static void main(String[] args) {
        String names[] = {"Graham, Ariel", "Perrott, Chloe",
            "Charles, Kandrice", "Seecharan, Anella", "Reyes, Aaliyah",
            "Graham, Ashleigh", "Reyes, Ayanna", "Greaves, Sherrelle"};
        int id[] = {3050,2795,4455,7824,6669,5000,5464,6050};

        Sorting_algorithms.parallel_sort(names, id, 0, MAX_NAMES-1);


        System.out.println("\nThe sorted names are\n");
        for (int h = 0; h < MAX_NAMES; h++)
            System.out.printf("%-20s %d\n", names[h], id[h]);
    }
}
