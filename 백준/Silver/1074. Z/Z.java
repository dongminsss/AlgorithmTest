import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = 1;

        for (int i = 1; i <= n; i++) {
            size = size * 2;
        }
        System.out.println(z(size, r , c));
    }

    static int z(int size ,int r, int c) {
        int index = 0;
        int n = size / 2;

        while (n > 0) {
            int half = n * n;
            if (r < n && c < n) {
                // 1사분면
            } else if (r < n && c >= n) {
                // 2사분면
                index += half;
                c -= n;
            } else if (r >= n && c < n) {
                // 3사분면
                index += 2 * half;
                r -= n;
            } else {
                // 4사분면
                index += 3 * half;
                r -= n;
                c -= n;
            }
            n /= 2;
        }
        return index;

    }
}
