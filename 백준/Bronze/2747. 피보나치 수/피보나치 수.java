import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int order = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(order));
        br.close();
    }

    public static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int result = 0;
        int prev = 1;
        int prevPrev = 0;
        for (int i = 2; i <= n; i++) {
            result = prev + prevPrev;
            prevPrev = prev;
            prev = result;
        }
        return result;
    }
}