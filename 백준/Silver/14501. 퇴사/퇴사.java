
import java.util.*;
import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int length;
    static int[] P;
    static int[] T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        T = new int[n];
        P = new int[n];
        length = n;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        solve(0,0);
        System.out.println(max);
    }

    private static void solve(int sum, int idx) {
        if(idx >= length) {
            max = Math.max(max, sum);
            return;
        }
        if(idx + T[idx] <= length) {
            solve(sum + P[idx], idx + T[idx]);
        }
        solve(sum, idx + 1);
    }
}