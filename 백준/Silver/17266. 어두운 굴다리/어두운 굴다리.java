import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        int answer = 1;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 1;
        int max = n;

        while (min <= max) {
            int mid = (min + max) / 2;
            if(cover(arr, n, mid)) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean cover(int[] arr, int length, int height) {
        int lastCovered = 0;

        for(int a : arr ) {
            if (a - height > lastCovered) {
                return false;
            }
            lastCovered = a + height;
        }

        return lastCovered >= length;
    }
}
