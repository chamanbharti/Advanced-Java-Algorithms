package algorithms;

import java.util.InputMismatchException;

@SuppressWarnings("ALL")

public class Generic_Sorting_Algorithms {

    public static final int ASCENDING_ORDER = 1;
    public static final int DESCENDING_ORDER = 2;

    private static class Comp_assign_count {
        private int count;

        public Comp_assign_count() {
            this.count = 0;
        }
        public Comp_assign_count(int initial_value) {
            this.validate_count(initial_value);
        }
        public void set_count(int new_count) {
            this.validate_count(new_count);
        }
        private void validate_count(int some_count) {
            if (some_count < 0) {
                this.count = 0;
            } else {
                this.count = some_count;
            }
        }
        public void increment()  {
            ++this.count;
        }
        public void add_count(int new_val) {
            if (new_val > 0) {
                this.count += new_val;
            }
        }
        public int get_count() {
            return this.count;
        }

    }

    /**
     * Sorts array <code>list</code> using the selection sort algorithm.
     * @param list Array of objects to sort.
     * @param lo Lower bound to consider during sorting process.
     * @param hi Upper bound index [exclusive] to consider during sorting process.
     * @param <T> Type for the objects found in the array.
     */
    public static <T extends Comparable<T>> void selection_sort(T[] list, int lo, int hi) {
        for (int h = lo; h < hi; h++) {
            int smallest = get_smallest_index(list, h, hi);
            swap_data(list, h, smallest);
        }
    }

    /**
     * Searches for the 'smallest' object found within an array of objects that are comparable.
     * @param list Array of objects to consider.
     * @param lo Lower bound index to be used during search procedure.
     * @param hi Upper bound index [exclusive] to use be used during search procedure.
     * @param <T> Type for the objects in array.
     * @return
     */
    public static <T extends Comparable<T>> int get_smallest_index(T[] list, int lo, int hi) {
        int small = lo;
        for (int h = lo + 1; h <= hi; h++)
            if (list[h].compareTo(list[small]) < 0)
                small = h;
        return small;
    }

    /**
     * Swapping objects found within an array of objects.
     * @param list Array to consider during swap operations.
     * @param i First swap index.
     * @param j Second swap index.
     * @param <T> Type for the objects in the array.
     */
    private static <T> void swap_data(T list[], int i, int j) {
        T hold = list[i];
        list[i] = list[j];
        list[j] = hold;
    }

    /**
     * Computes the total comparison operations used to get the smallest element's index in
     * an array of objects. Provided the objects are comparable.
     * @param list Array of objects to compare.
     * @param lo Lower bound index to consider during comparison.
     * @param hi Upper bound index [exclusive] to consider during comparison.
     * @param comp_count Object used to store the number of assignment operations.
     * @param <T> Comparable object type.
     * @return The 'smallest' object in the array of objects.
     */
    public static <T extends Comparable<T>> int get_smallest_comp_count(T list[], int lo, int hi, Comp_assign_count comp_count) {
        int small = lo;
        for (int h = lo + 1; h <= hi; h++) {
            comp_count.increment();
            if (list[h].compareTo(list[small]) < 0) {
                comp_count.increment();
                small = h;
            }
        }
        return small;
    }

    /**
     * Computes the total assignment operations used to get the smallest elements index in
     * an array of objects. Provided the objects are comparable.
     * @param list Array of objects to compare
     * @param lo Lower bound index to consider during comparison
     * @param hi Upper [exclusive] bound index to consider during comparison
     * @param assign_count Object used to store the number of assignment operations
     * @param <T> Comparable object type
     * @return The 'smallest' object in the array of objects.
     */
    public static <T extends Comparable<T>> int get_smallest_assign_count(T list[], int lo, int hi, Comp_assign_count assign_count) {
        int small = lo;
        assign_count.increment(); // for the above assignment

        for (int h = lo +1; h <= hi; h++) {
            assign_count.increment();       // for 'h = lo+1' assignment
            if (list[h].compareTo(list[small]) < 0) {
                small = h;
                assign_count.increment();   // for the above assignment
            }
            assign_count.increment(); // for 'h++' increment call
        }
        return small;
    }

    /**
     * Sorts the <code>list</code> array of objects and returns the number of comparisons done
     * during the sort process.
     * @param list Array of objects to sort.
     * @param lo Lower bound index to consider during search.
     * @param hi Upper bound index [exclusive] to consider during search.
     * @param <T> Type for the objects in array.
     * @return Number of comparisons done during sorting process.
     */
    public static <T extends Comparable<T>> int selection_sort_count_comparison(T list[], int lo, int hi) {
        Comp_assign_count comp_count = new Comp_assign_count();
        for (int h = lo; h < hi; h++) {
            comp_count.increment();
            int s = get_smallest_comp_count(list, h, hi, comp_count);
            swap_data(list, h, s);
        }
        return comp_count.get_count();
    }

    /**
     * Sorts the <code>list</code> array of objects and returns the number of assignments done
     * during the sort process.
     * @param list Array of objects to sort.
     * @param lo Lower bound index to consider during search.
     * @param hi Upper bound index [exclusive] to consider during search.
     * @param <T> Type for the objects in array.
     * @return Number of assignment done during sorting process.
     */
    public static <T extends Comparable<T>> int selection_sort_count_assignment(T list[], int lo, int hi) {
        Comp_assign_count assign_count = new Comp_assign_count();
        assign_count.increment(); // for the assignment 'h = lo' below

        for (int h = lo; h < hi; h++) {
            int smallest  = get_smallest_assign_count(list, h, hi, assign_count);
            swap_data(list, h, smallest);
            assign_count.add_count(3); // 3 assignment operations done in function 'swap_data'
            assign_count.increment();
        }
        return assign_count.get_count();
    }

    /**
     * Sorts the array <code>list</code> using insertion sort algorithm. The order of sorting
     * (ascending or descending) must be specified.
     * <br>
     *     1. For ascending order use <code>Generic_Sorting_Algorithms.ASCENDING_ORDER</code>
     *     2. For descending order use <code>Generic_Sorting_Algorithms.DESCENDING_ORDER</code>
     *
     * @param list Array of objects to sort.
     * @param n Size of the array to consider
     * @param order Order to use.
     * @param <T> Type of objects in array.
     */
    public static <T extends Comparable<T>> void insertion_sort(T list[], int n, int order) {
        boolean ascending;
        if (order == ASCENDING_ORDER) {
            ascending = true;
        } else if (order == DESCENDING_ORDER) {
            ascending = false;
        } else {
            throw new InputMismatchException("Expected 1 or 2 for parameter 'order'");
        }
        // Sort list[0] to list[n-1] in ascending order

        for (int h = 1; h < n; h++) {
            T key = list[h];
            int k = h-1;        // Starting comparison with previous item.

            if (ascending) {
                while (k >= 0 && (key.compareTo(list[k]) < 0)) {
                    list[k+1] = list[k];
                    --k;
                }
                list[k+1] = key;
            } else {
                while (k >= 0 && (key.compareTo(list[k]) > 0)) {
                    list[k+1] = list[k];
                    --k;
                }
                list[k+1] = key;
            }

        }
    }

}
