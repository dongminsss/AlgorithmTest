
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        if(queue.size() == 1) System.out.println(queue.poll());
        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
            if(queue.size() == 1) {
                System.out.println(queue.poll());
            }
        }



    }
}