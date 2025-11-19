import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max , arr[i]);
        }
        System.out.println(binarySearch(arr, max, m));
    }

    private static int binarySearch(int[] arr, int n, int target) {
        int min = 0;
        int max = n;
        int result = 0;
        while(min <= max) {
            long sum = 0;
            int middle = (max + min) / 2;
            for(int i = 0; i<arr.length; i++) {
                if(arr[i] > middle) sum += arr[i] - middle;
            }
            if(sum < target) {
                max = middle -1;

            } else {
                min = middle + 1;
                result = middle;
            }
        }
        return result;
    }
}