
import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int targetNumber;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        targetNumber = s;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);

        if(targetNumber == 0) count--;

        System.out.println(count);
    }

    private static void solve(int index, int sum) {
        if(index == arr.length) {
            if(sum == targetNumber){
                count++;
            }
            return;
        }

        solve(index + 1, sum + arr[index]);

        solve(index + 1, sum);
    }
}