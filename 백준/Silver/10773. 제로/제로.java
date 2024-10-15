
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) {
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(number);
            }

        }
        int result = 0;
        for(Integer i : stack) {
            result += i;
        }
        System.out.println(result);
    }
}