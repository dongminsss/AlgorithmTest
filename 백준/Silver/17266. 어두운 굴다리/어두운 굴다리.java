import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = n;
        int min = 1;
        int result = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            if(searchBoolean(arr, mid, n)) {
                max = mid - 1;
                result = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean searchBoolean (int[] arr, int mid, int length) {
        int start = 0;
        for(int i: arr) {
            if(i - mid <= start) {
                start = i + mid;
            } else {
                return false;
            }
        }
        return start >= length;
    }


}
