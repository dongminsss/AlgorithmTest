import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int index = 1;

        while(deque.size() > 1) {
            if(index % 2 == 0) {
                deque.offer(deque.poll());
            } else {
                deque.poll();
            }
            index++;
        }
        System.out.println(deque.poll());
    }
}
