import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int lope = Integer.parseInt(br.readLine().trim());
            arr[i] = lope;
        }

        Arrays.sort(arr);
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            int currentWeight = arr[i] * (n - i);
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
        }
        System.out.println(maxWeight);
    }
}
