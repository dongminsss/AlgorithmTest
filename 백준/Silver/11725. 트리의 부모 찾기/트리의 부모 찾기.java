import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] roots = new int[n+1];
        bfs(graph, 1, new boolean[n+1], roots);
        for(int i = 2; i<=n; i++) {
            System.out.println(roots[i]);
        }

    }
    private static void bfs(List<List<Integer>> graph, int start, boolean[] visited,int[] roots) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        visited[start] = true;
        while(!dq.isEmpty()) {
            int root = dq.poll();
            for(int child : graph.get(root)) {
                if(!visited[child]) {
                    roots[child] = root;
                    dq.offer(child);
                    visited[child] = true;
                }
            }
        }
    }
}