import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean flag = false;
        for(int i = 1; i <= n; i++) {
            int sum = i;
            int number = i;
            while( number >  0) {
                sum += number % 10;
                number = number / 10;
            }

            if(sum == n) {
                System.out.println(i);
                flag = true;
                break;
            }
        }
        if(!flag) {
            System.out.println("0");
        }
    }
}