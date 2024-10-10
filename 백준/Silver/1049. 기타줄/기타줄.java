
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] six = new int[m];
        int[] one = new int[m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            six[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(six);
        Arrays.sort(one);

        while(n > 0) {
            int s = six[0];
            int o = one[0] * 6;
            if(n < 6) {
                if(s < one[0] * n) {
                    count += s;
                } else {
                    count += (one[0] * n);
                }
                n = 0;
            } else {
                if(s > o) {
                    count += o;
                } else {
                    count += s;
                }
                n -= 6;
            }
        }
        System.out.println(count);


    }
}