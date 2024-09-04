import java.io.*;
import java.util.*;

public class Main {
    static int length;
    static int[] numbers;
    static int[] cals;
    static long minNumber = Integer.MAX_VALUE;
    static long maxNumber = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        length = n;
        numbers = new int[n];
        cals = new int[4];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            cals[i] = Integer.parseInt(st.nextToken());
        }
        cal(numbers[0], 1);
        System.out.println(maxNumber);
        System.out.println(minNumber);
    }
    private static void cal(int n , int depth) {
        if(depth == length) {
            maxNumber = Math.max(maxNumber, n);
            minNumber = Math.min(minNumber, n);
            return;
        }
        for(int i = 0; i<4; i++) {
            if(cals[i] > 0) {
                cals[i]--;

                if(i == 0) {
                    cal(n + numbers[depth], depth + 1);
                } else if ( i == 1) {
                    cal(n - numbers[depth], depth + 1);
                } else if ( i == 2) {
                    cal(n * numbers[depth], depth + 1);
                } else if ( i == 3) {
                    cal(n / numbers[depth], depth + 1);
                }

                cals[i]++;
            }
        }
    }

}
