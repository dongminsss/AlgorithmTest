
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int[] testCase = new int[n];
        for(int i = 0; i < n; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, testCase[i]);
        }

        int[] dp_zero = new int[max + 1];
        int[] dp_one = new int[max + 1];

        dp_zero[0] = 1;
        dp_one[0] = 0;
        if(max >= 1) {
            dp_zero[1] = 0;
            dp_one[1] = 1;
        }

        for(int i = 2; i <= max; i++) {
            dp_zero[i] = dp_zero[i - 1] + dp_zero[i - 2];
            dp_one[i] = dp_one[i - 1] + dp_one[i - 2];
        }

        for(int i = 0; i< n; i++) {
            System.out.println(dp_zero[testCase[i]] + " " + dp_one[testCase[i]]);
        }



    }

}