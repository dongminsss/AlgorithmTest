
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = -1;

        for(int i = n / 5; i>= 0; i--) {
            int number = n - (i * 5);
            if(number % 3 == 0) {
                result = i + (number / 3);
                break;
            }
        }

        System.out.println(result);

    }
}