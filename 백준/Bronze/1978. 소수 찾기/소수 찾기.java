
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int answer = 0;
        for(int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(input[i]);
            boolean isPrime = true;
            if(n == 1) isPrime =false;
            for(int j = 2; j<=Math.sqrt(n); j++) {
                if(n % j == 0) isPrime = false;
            }
            if(isPrime) answer++;
        }
        System.out.println(answer);
    }
}