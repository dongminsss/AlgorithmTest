
import java.util.*;
import java.io.*;

public class Main {
    private static int length;
    private static int[] numbers;
    private static int[] cals;
    static long minNumber = Integer.MAX_VALUE;
    static long maxNumber = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        cals = new int[4];
        length = n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++) {
            cals[i] = Integer.parseInt(st.nextToken());
        }
        calculate(numbers[0], 1);
        System.out.println(maxNumber);
        System.out.println(minNumber);
    }

    private static void calculate(int number, int depth) {
        if(depth == length) {
            maxNumber = Math.max(maxNumber, number);
            minNumber = Math.min(minNumber, number);
            return;
        }
        for(int i = 0; i<4; i++) {
            if(cals[i] > 0) {
                cals[i]--;
                if (i == 0) {
                    calculate(number + numbers[depth], depth + 1);
                } else if (i == 1) {
                    calculate(number - numbers[depth], depth + 1);
                } else if (i == 2) {
                    calculate(number * numbers[depth], depth + 1);
                } else {
                    calculate(number / numbers[depth], depth + 1);
                }

                cals[i]++;
            }
        }

    }


}