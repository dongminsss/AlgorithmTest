import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] board = new int[101];

        for(int i = 1; i<=100; i++) {
            board[i] = i;
        }

        for(int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }
        System.out.println(bfs(board));
    }

    private static int bfs(int[] board) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        int[] dp = new int[101];
        dp[1] = 0;

        while (!dq.isEmpty()) {
            int current = dq.poll();
            if(current == 100) return dp[current];
            for(int i = 1; i<=6; i++) {
                int next = current + i;
                if(next < 101) {
                    next = board[next];
                    if(dp[next] == 0) {
                        dp[next] = dp[current] + 1;
                        dq.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}