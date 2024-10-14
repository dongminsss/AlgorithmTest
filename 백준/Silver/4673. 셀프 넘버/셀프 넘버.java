
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int length = 10000;
        List<Integer> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            list.add(i);
            int n = i;
            int sum = i;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            arr.add(sum);
        }

        for(Integer i : arr) {
            list.remove(i);
        }
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}