
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = 1;
        for(int i = 0; i < n; i++) {
            size = size * 2;
        }
        System.out.println(solve(size, r, c));
    }

    private static int solve(int size, int r, int c) {
        int idx = 0;
        int n = size / 2;

        while (n > 0) {
            int half = n * n;

            if( r < n && c < n) {

            } else if ( r < n && c >= n) {
                idx += half;
                c -= n;
            } else if (r >= n && c < n) {
                idx += 2 * half;
                r -= n;
            } else {
                idx += 3 * half;
                r -= n;
                c -= n;
            }
            n /= 2;
        }
        return idx;
    }
}