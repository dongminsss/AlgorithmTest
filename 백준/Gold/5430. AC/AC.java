import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            sb.append(solution(cmd, n, str)).append('\n');
        }
        System.out.print(sb);
    }

    private static String solution(String cmd, int n, String str) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(str.substring(1, str.length() - 1), ",");
            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
        }

        boolean isReversed = false;

        for (char c : cmd.toCharArray()) {
            if (c == 'R') {
                isReversed = !isReversed;
            } else {
                if (deque.isEmpty()) {
                    return "error";
                }

                if (isReversed) {
                    deque.pollLast(); 
                } else {
                    deque.pollFirst(); 
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        if (!deque.isEmpty()) { 
            if (isReversed) {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
        }

        sb.append(']');
        return sb.toString();
    }
}
