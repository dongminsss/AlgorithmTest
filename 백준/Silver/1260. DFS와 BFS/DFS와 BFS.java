import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        dfsVisited = new boolean[n + 1];
        bfsVisited = new boolean[n + 1];
        for (int i = 0; i < n+1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            adjList.get(node).add(edge);
            adjList.get(edge).add(node);

        }
        for (ArrayList<Integer> list : adjList) {
            list.sort(null);
        }
        dfs(v);
        bfs(v);

        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());
    }

    static void dfs(int start) {
        if(!dfsVisited[start]) {
            dfsVisited[start] = true;
            sb1.append(start).append(" ");
            for(Integer v : adjList.get(start)) {
                dfs(v);
            }
        }
    }
    static void bfs(int start) {
        if(bfsVisited[start]) {
            return;
        }
            bfsVisited[start] = true;
            deque.offer(start);
            sb2.append(start).append(" ");
            while (!deque.isEmpty()) {
                int v = deque.poll();
                for(Integer w : adjList.get(v)) {
                    if(!bfsVisited[w]) {
                        bfsVisited[w] = true;
                        deque.offer(w);
                        sb2.append(w).append(" ");
                    }
                }
            }

    }
}