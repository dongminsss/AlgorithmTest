import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(st.nextToken()));
        }

        deque = deque
                .stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayDeque::new));
        int result = 0;
        while(deque.size() > 1) {
            result++;
            int n1 = deque.removeLast();
            int n2 = deque.removeLast();

            deque.addLast(n1 + n2);

            if(deque.size() >= 2) {
                int n3 = deque.removeFirst();
                if (n3 > 1) {
                    deque.addFirst(n3 - 1);
                }
            }
        }
        System.out.println(result);
    }
}