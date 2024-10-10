
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count = 1;

        while (n > 0) {
            count *= n;
            n--;
        }
        System.out.println(count);


    }
}