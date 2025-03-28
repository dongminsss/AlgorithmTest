
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = Math.min(n, m);
        int min = Math.max(n, m);
        while(true) {
            if(n % max == 0 && m % max == 0) {
                break;
            }
            max--;
        }
        while(true) {
            if(min % n == 0 && min % m == 0) break;
            min++;
        }
        System.out.println(max);
        System.out.println(min);

    }
}