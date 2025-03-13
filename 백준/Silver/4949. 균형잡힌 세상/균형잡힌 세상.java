import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            if(str.equals(".")) return;

            char[] chars = str.toCharArray();

            for (int i = 0; i < chars.length; i++) {

                if (chars[i] == '('  || chars[i] == '[') {
                    stack.push(chars[i]);
                } else if (chars[i] == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(chars[i]);
                    }
                } else if (chars[i] == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(chars[i]);
                    }
                }

            }
            if(stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }

}