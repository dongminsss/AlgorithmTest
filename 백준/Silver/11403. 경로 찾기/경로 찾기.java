import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                if(st.nextToken().equals("1")) {
                    graph.get(i).add(j);
                }
            }
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                boolean[] visited = new boolean[n];
                dfs(i, j, visited);
                if(visited[j]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

    }

    private static void dfs(int node, int end, boolean[] visited) {
        for(int next : graph.get(node)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next, end, visited);

            }
        }
    }
}