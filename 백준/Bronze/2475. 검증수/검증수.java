import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int count = 0;
        for(String num : input) {
            int number = Integer.parseInt(num);
            count += number * number;
        }
        System.out.println(count % 10);

    }
}
