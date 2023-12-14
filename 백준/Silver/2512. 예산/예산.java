import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long M = Long.parseLong(br.readLine());
        long sum = 0;
        for (int i = 0; i<length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        if(sum > M) {
            binarySearch(M, arr);
        } else {
            System.out.println(arr[length-1]);
        }
    }
    public static void binarySearch(long number, int[] arr) {
        int start = 0;
        int end = arr[arr.length -1];
        int reuslt = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            for(int i = 0; i<arr.length; i++) {
                if(arr[i] < middle) {
                    sum += arr[i];
                } else {
                    sum += middle;
                }
            }
            if(sum <= number) {
                start = middle + 1;
                reuslt = middle;
            } else {
                end = middle -1;
            }
        }
        System.out.println(reuslt);
    }
}
