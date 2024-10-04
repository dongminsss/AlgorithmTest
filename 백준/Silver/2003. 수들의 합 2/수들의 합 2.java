
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            int sum = arr[i];
            for(int j = i+1; j < n; j++) {
                if(sum < m ) {
                    sum += arr[j];
                }  else {
                    break;
                }
            }
            if(sum == m) count++;

        }
        System.out.println(count);
    }
}