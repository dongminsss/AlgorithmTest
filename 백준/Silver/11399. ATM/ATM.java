import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[length];
        for(int i = 0; i<length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int sum = 0;
        for(int i = 0; i<length; i++) {
            int subSum = 0;
            for(int j= 0; j<=i; j++) {
                subSum += numbers[j];
            }
            sum += subSum;
        }
        System.out.println(sum);
    }
}
