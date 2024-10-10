
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            String str = sc.next();
            if(str.contains("push")) {

                stack.push(sc.nextInt());
            } else if(str.contains("pop")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if(str.contains("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(str.contains("top")) {

                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.getFirst());
                }
            } else if(str.contains("size")) {
                System.out.println(stack.size());
            }
        }


    }
}