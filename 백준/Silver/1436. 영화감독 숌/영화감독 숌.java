
import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int targetNumber;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int number = 0;
        String magicNumber = "666";
        while (n != count) {
            number++;
            String str = String.valueOf(number);

            if(str.contains(magicNumber)) {
                count++;
            }

        }
        System.out.println(number);

    }
}