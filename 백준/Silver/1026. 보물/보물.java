import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] A = new int[length];
        int[] B = new int[length];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i =  0; i < length; i++) {
            A[i] = Integer.parseInt(st1.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int j = length - 1;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += A[j] * B[i];
            j--;
        }
        System.out.println(sum);
    }

}
