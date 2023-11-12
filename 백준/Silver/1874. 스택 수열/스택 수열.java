import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numbersCount = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int[] numbersArr = new int[numbersCount];
        int number = 1;
        Stack<Integer> stack = new Stack<>();
        boolean result = true;
        for(int i = 0; i<numbersCount; i++) {
            numbersArr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i<numbersCount; i++) {
            if(numbersArr[i] >= number) {
                while (numbersArr[i] >= number) {
                    stack.push(number++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int lastNumber = stack.pop();
                if(numbersArr[i] < lastNumber) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }

        }
        if (result) System.out.println(sb);

    }
}