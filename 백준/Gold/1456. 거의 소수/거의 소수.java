import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        long[] arr = new long[10000001];
        for(int i = 2; i<arr.length; i++){
            arr[i] = i;
        }
        for(int i = 2; i<=Math.sqrt(arr.length); i++) {
            if(arr[i] == 0) continue;
            for(int j = i * 2; j<arr.length; j = j + i) {
                arr[j] = 0;
            }
        }
        int count = 0;
        for(int i = 2; i<arr.length; i++){
            if(arr[i] != 0) {
                long temp = arr[i];
                while((double)arr[i] <= (double)end / (double) temp) {
                    if((double)arr[i] >= (double) start / (double)temp) {
                        count++;
                    }
                    temp = temp * arr[i];
                }
            }
        }
        System.out.println(count);
    }
}
