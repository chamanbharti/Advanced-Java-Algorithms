package algorithms;

@SuppressWarnings("Duplicates")
public class Sorting_algorithms {

    private static class Comp_assign_count {
        private int count;

        public Comp_assign_count(int initial_val) {
            this.validate_count(initial_val);
        }
        public Comp_assign_count() {
            this.count = 0;
        }
        public int get_count() {
            return this.count;
        }
        public void set_count(int some_val) {
            this.validate_count(some_val);
        }
        private void validate_count(int some_val) {
            if (some_val < 0) {
                this.count = 0;
            } else {
                this.count = some_val;
            }
        }
        public void increment() {
            ++this.count;
        }
        public void add_count(int new_val) {
            if (new_val > 0) {
                this.count += new_val;
            }
        }

    }

    public static void selection_sort(int[] list, int lo, int hi) {
        // sort list[lo] to list[hi] in ascending order
        for (int h = lo; h < hi; h++) {
            int s = get_smallest(list, h, hi);
            swap_data(list, h, s);
        }
    }

    private static int get_smallest(int list[], int lo, int hi) {
        // return location of smallest from list[lo...hi]
        int small = lo;
        for (int h = lo + 1; h <= hi; h++)
            if (list[h] < list[small]) small = h;
        return small;
    }

    private static int get_smallest_comp_count(int list[], int lo, int hi, Comp_assign_count comp_count) {
        int small = lo;
        for (int h = lo + 1; h <= hi; h++) {
            comp_count.increment();
            if (list[h] < list[small]) {
                comp_count.increment();
                small = h;
            }
        }
        return small;
    }

    private static int get_smallest_assign_count(int list[], int lo, int hi, Comp_assign_count assign_count) {
        int small = lo;
        assign_count.increment();
        assign_count.increment();
        for (int h = lo + 1; h <= hi; h++) {
            if (list[h] < list[small]) {
                small = h;
                assign_count.increment();
            }
            assign_count.increment();
        }
        return small;
    }

    private static void swap_data(int list[], int i, int j) {
        // swap elements list[i] and list[j]
        int hold = list[i];
        list[i] = list[j];
        list[j] = hold;
    }

    public static int selection_sort_count_comparison(int list[], int lo, int hi) {
        Comp_assign_count comp_count = new Comp_assign_count();
        for (int h = lo; h < hi; h++) {
            comp_count.increment();
            int s = get_smallest_comp_count(list, h, hi, comp_count);
            swap_data(list, h, s);
        }
        return comp_count.get_count();
    }

    public static int selection_sort_count_assignment(int list[], int lo, int hi) {
        Comp_assign_count assign_count = new Comp_assign_count();
        assign_count.increment();
        for (int h = lo; h < hi; h++) {
            int s = get_smallest_assign_count(list, h, hi, assign_count);
            swap_data(list, h, s);
            assign_count.add_count(3);
            assign_count.increment();
        }
        return assign_count.get_count();
    }

    /**
     * Insertion sort algorithm, for sorting an <code>int</code> array.
     * @param list Array to sort
     * @param n Length of the array to consider
     */
    public static void insertion_sort(int list[], int n) {

        // Sort list[0] to list[n-1] in ascending order

        for (int h = 1; h < n; h++) {
            int key = list[h];
            int k = h-1;        // Starting comparing with previous item

            // To sort in ascending order, all we have to do is change '<' to '>' in
            // the 'while' loop condition like this:
            //
            //          while (k >= 0 && key > list[k]) .....
            //

            while (k >= 0 && key < list[k]) {
                list[k+1] = list[k];
                --k;
            }
            list[k+1] = key;
        }
    }

    /**
     * Insertion sort algorithm, for sorting an <code>int</code> array, from
     * specified indices.
     * @param list Array to sort
     * @param lo Lower bound to use during sorting.
     * @param hi Upper [exclusive] bound to use during sorting.
     */
    public static void insertion_sort(int list[], int lo, int hi) {

        // Sort list[0] to list[n-1] in ascending order

        for (int h = lo + 1; h <= hi; h++) {
            int key = list[h];
            int k = h-1;        // Stark comparing with previous item;

            // To sort in ascending order, all we have to do is change '<' to '>' in
            // the 'while' loop condition like this:
            //
            //          while (k >= 0 && key > list[k]) .....
            //

            while (k >= lo && key < list[k]) {
                list[k+1] = list[k];
                --k;
            }
            list[k+1] = key;
        }
    }

    /**
     * Sorting an array, using the insertion sort algorithm. This algorithm,
     * will sort the array starting from <code>lo</code> to <code>hi</code>
     * @param list Array to sort.
     * @param lo Lower bound of array to consider during sorting.
     * @param hi Upper [exclusive] bound of array to consider during sorting.
     * @return
     */
    public static int insertion_sort_comparison_counts(int list[], int lo, int hi) {
        Comp_assign_count comp_count = new Comp_assign_count();
        for (int h = lo + 1; h <= hi; h++) {
            comp_count.increment();     // after comparing 'h < len'
            int key = list[h];
            int k = h-1;

            while (k >= 0 && key < list[k]) {
                comp_count.increment(); // for 'k >= 0'
                comp_count.increment(); // for 'key < list[k]'
                list[k+1] = list[k];
                --k;
            }
            list[k+1] = key;
        }
        return comp_count.get_count();
    }

    /**
     * Sorting an array using the insertion sort algorithm. Sorting algorithm
     * starts from <code>lo</code> to <code>hi-1</code>
     * @param list Array to sort
     * @param lo Lower bound of array considered during sorting.
     * @param hi Upper [exclusive] bound of array considered during sorting
     * @return
     */
    public static int insertion_sort_assignments_counts(int list[], int lo, int hi) {
        Comp_assign_count assign_count = new Comp_assign_count();
        for (int h = lo + 1; h <= hi; h++) {
            assign_count.increment();   // for 'h = lo + 1'
            int key = list[h];
            int k = h-1;

            assign_count.increment(); // for 'key' above
            assign_count.increment(); // for 'k' above

            while (k >= 0 && key < list[k]) {
                list[k+1] = list[k];
                --k;
                assign_count.increment(); // for 'list[k+1] = list[k]'
                assign_count.increment(); // for '--k'
            }
            list[k+1] = key;
            assign_count.increment();   // for 'list[k+1] = key'
        }
        return assign_count.get_count();
    }

    /**
     * Adds a new item in an appropriate place within a sorted array.
     * @param new_item Item to add in place
     * @param list Array to which item is to be added.
     * @param m Lower bound of the array.
     * @param n Upper [exclusive] bound of the array.
     */
    public static void insert_in_place(int new_item, int list[], int m, int n) {
        // list[m] to list[n] are sorted.
        // insert 'new_item' so that list[m] to list[n+1] are sorted
        int k = n;
        while (k >= m && new_item < list[k]) {
            list[k+1] = list[k];
            --k;
        }
        list[k+1] = new_item;
    }

    /**
     * Sorting an array of Strings using insertion sort algorithm.
     * Sorting algorithm considers <code>lo</code> and <code>hi</code> during sort.
     * <code>hi</code> is exclusive.
     * @param list Array to sort.
     * @param lo Lower bound to consider during sort.
     * @param hi Upper bound [exclusive] to consider during sort.
     */
    public static void insertion_sort(String[] list, int lo, int hi) {
        for (int h = lo + 1; h <= hi; h++) {
            String key = list[h];
            int k = h - 1;  // start comparing with previous item
            while (k >= lo && key.compareToIgnoreCase(list[k]) < 0) {
                list[k+1] = list[k];
                --k;
            }
            list[k+1] = key;
        }
    }

    public static void parallel_sort(String[] list, int id[], int lo, int hi) {
        // Sort the names in list[lo] to list[hi] in alphabetical order,
        // ensuring that each name remains with its original id number.
        for (int h = lo + 1; h <= hi; h++) {
            String key = list[h];
            int m = id[h];
            int k = h-1;
            while (k >= lo && key.compareToIgnoreCase(list[k]) < 0) {
                list[k+1] = list[k];
                id[k+1] = id[k];
                --k;
            }
            list[k+1] = key;
            id[k+1] = m;    // store the id number in the same position as the name
        }
    }

    // ################### TESTING ZONE #########################/

}






































































































