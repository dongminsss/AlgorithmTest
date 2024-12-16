
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] primeNumber = new boolean[m + 1];
        primeNumber[0] = primeNumber[1] = true;

        for(int i = 2; i<= Math.sqrt(m); i++) {
            if(!primeNumber[i]) {
                for(int j = i + i; j <=m; j += i) {
                    primeNumber[j] = true;
                }
            }

        }

        for(int i = n; i<=m; i++) {
            if(!primeNumber[i]) System.out.println(i);
        }


    }
}