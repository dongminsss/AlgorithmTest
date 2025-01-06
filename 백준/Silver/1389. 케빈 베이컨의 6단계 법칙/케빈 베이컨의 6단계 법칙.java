import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] bakenNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        bakenNumber = new int[N+1];
        for(int i = 0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= N; i++) {
            int[] dist = bfs(i, N);

            for(int j = 1; j <= N; j++) {
                bakenNumber[j] += dist[j] ;
            }
        }

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i = 1; i <= N; i++) {
            if(min > bakenNumber[i]) {
                min = bakenNumber[i];
                minIdx = i;
            }
        }
        System.out.println(minIdx);
        // System.out.println(Arrays.toString(bakenNumber));

    }

    private static int[] bfs(int start, int N) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph.get(cur)) {
                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }
        return dist;
    }
}
