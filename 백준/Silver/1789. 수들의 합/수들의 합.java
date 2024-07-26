import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        long s = 1;
        int count = 1;
        while (true) {
            n = n - s;
            s += 1;
            if ( n < s) {
                break;
            } else {
                count++;
            }
        }
        System.out.println(count);

    }
}
