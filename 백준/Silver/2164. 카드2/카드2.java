import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int cardCount = Integer.parseInt(br.readLine());
        for(int i = 0; i<cardCount; i++) {
            queue.add(i+1);
        }
        while (queue.size() != 1) {
            queue.remove();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());

    }
}