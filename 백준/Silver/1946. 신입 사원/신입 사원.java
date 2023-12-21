import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i <testCase ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int[][] arr = new int[length][2];
            int count = 1;
            for (int j = 0; j <length ; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                arr[first-1][0] = first;
                arr[first-1][1] = second;
            }

            int max = arr[0][1];

            for (int j = 1; j <length ; j++) {
                if(max > arr[j][1]) {
                    max = arr[j][1];
                    count++;
                }
            }
            System.out.println(count);
        }

    }

}
