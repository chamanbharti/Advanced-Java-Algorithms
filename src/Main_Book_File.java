import java.awt.*;


public class Main_Book_File {

    public static void main(String[] args) {

        int testing[] = {8, 7, 6, 5, 4, 3, 2, 1};
        insertion_sort(testing);
        print_array(testing);

    }

    public static <T> void print_array(T some_arr[]) {
        for (T array_val : some_arr)
            System.out.print(array_val + " | ");
        System.out.println();
    }
    public static void print_array(int[] some_arr) {
        for (int val : some_arr)
            System.out.println(val + " | ");
        System.out.println();
    }

    public static void insertion_sort(int[] array) {
        if (array == null) {
            System.err.println("Invalid array");
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int tmp_key = array[i];
            int j = i-1;
            while (j > 0 && array[j] > tmp_key) {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = tmp_key;
        }
    }
}
