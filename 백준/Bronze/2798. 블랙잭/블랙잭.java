import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int result = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            for(int j = i-1; j>=0; j--) {
                for(int k = j - 1; k>=0; k--) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= max) {
                        result = Math.max(sum , result);
                    }
                }
            }
        }
        System.out.println(result);

    }

}
