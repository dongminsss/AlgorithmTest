import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N==K) {
            System.out.println("0");
        } else {
            System.out.println(bfs(N, K));
        }

    }

    private static int bfs(int start, int end) {
        int[] dx = {1,-1,2};
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        deque.offer(new int[] {start, 0});
        visited[start] = true;
        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0];
            int depth = current[1];
            if(x == end) return depth;
            for(int i = 0; i<3; i++) {
                int nextX = x;
                if(i == 2) {
                    nextX *= dx[i];
                } else {
                    nextX += dx[i];
                }
                if(nextX >= 0 && nextX <= 100000 && !visited[nextX]) {
                    deque.offer(new int[]{nextX, depth+1});
                    visited[nextX] = true;
                }
            }
        }

        return 0;
    }
}