import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = 1;
        while ( n < k) {
            n *= 2;
        }
        int div = n;
        int count = 0;
        while (true) {
            if ( k % div != 0) {
                div /= 2;
                count++;
            } else {
                break;
            }
        }
        System.out.print(n + " " + count);
    }
}