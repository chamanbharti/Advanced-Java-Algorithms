import java.awt.*;


public class Main_Book_File {

    public static void main(String[] args) {

        Button test = new Button("test");
        Color color = test.getBackground();
        System.out.println(color);

    }

    public static <T> void print_array(T some_arr[]) {
        for (T array_val : some_arr)
            System.out.print(array_val + " | ");
        System.out.println();
    }
}
