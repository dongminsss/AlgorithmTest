import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for(int i = 0; i<length; i++) {
            cards.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while (cards.size() > 1) {
            int cost = cards.poll() + cards.poll();
            sum+=cost;
            cards.add(cost);
        }
        System.out.println(sum);
        
    }
}
