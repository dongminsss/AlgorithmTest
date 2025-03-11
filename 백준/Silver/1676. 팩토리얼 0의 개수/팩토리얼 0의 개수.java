import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int five = 5;
        int count = 0;
        while(five <= n) {
            count += n / five;
            five *= 5;
        }
        System.out.println(count);




    }
}
