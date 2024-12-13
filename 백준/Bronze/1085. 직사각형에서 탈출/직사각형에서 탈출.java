
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();

        int w = input.nextInt();
        int h = input.nextInt();

        int[] arr = new int[]{x, y, w - x, h - y};
        Arrays.sort(arr);
        System.out.println(arr[0]);






    }
}