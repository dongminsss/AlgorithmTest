import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                if(!stack.isEmpty() && stack.peek() == '(' && input[j] == ')') {
                    stack.pop();
                } else {
                    stack.push(input[j]);
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

}