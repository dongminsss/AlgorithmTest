import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            Node node = new Node(i, value);

            while (!deque.isEmpty() && deque.getLast().value > value) {
                deque.removeLast();
            }
            deque.add(node);
            if (deque.getFirst().node <= i-l) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value+ " ");
        }
        bw.flush();
        bw.close();
    }
    static class Node {
        public int node;
        public int value;
        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }

}