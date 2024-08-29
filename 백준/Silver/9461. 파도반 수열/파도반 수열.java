import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[100];
        for(int i = 0; i < 100; i++) {
            if(i == 1 || i == 2 || i ==0) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 2] + arr[i - 3];
            }
        }

        int n = Integer.parseInt(br.readLine());
        long[] arr2 = new long[n];
        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            arr2[i] = arr[k-1];
        }
        for(long l : arr2) {
            System.out.println(l);
        }
    }
}