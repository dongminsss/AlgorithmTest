
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 1;
        int sum = 1;
        int answer = 1;
        while (count < n) {
            count = count + (sum * 6);
            sum++;
            answer++;
        }
        System.out.println(answer);
    }
}