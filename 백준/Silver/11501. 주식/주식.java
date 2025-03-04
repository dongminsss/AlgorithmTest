import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int days = Integer.parseInt(br.readLine());

            int[] stocks = new int[days];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < days; j++) {
                stocks[j] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            long answer = 0;
            for (int j = days -1; j >= 0; j--) {
                if(max < stocks[j]) {
                    max = stocks[j];
                } else {
                    answer += (max - stocks[j]);
                }
            }
            System.out.println(answer);
        }
    }
}
