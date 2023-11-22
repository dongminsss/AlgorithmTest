import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<ArrayList<Integer>> list;
    static boolean[] visited;
    static boolean[] visited2;
    static StringBuffer sb;
    static StringBuffer sb2;
    static Queue<Integer> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        queue = new LinkedList<>();
        sb = new StringBuffer();
        sb2 = new StringBuffer();
        visited = new boolean[nodeCount+1];
        visited2 = new boolean[nodeCount+1];
        for(int i = 0; i<nodeCount+1; i++) {
            ArrayList<Integer> nodeList = new ArrayList<>();
            list.add(nodeList);
        }
        for(int i = 0; i<edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int nodeConnect = Integer.parseInt(st.nextToken());
            list.get(node).add(nodeConnect);
            list.get(nodeConnect).add(node);
        }
        for(ArrayList<Integer> i : list) {
            i.sort(null);
        }
        dfs(start);
        bfs(start);
        System.out.println(sb);
        System.out.println(sb2);
    }

    public static void dfs(int visit) {
        if(visited[visit]) return;
        visited[visit] = true;
        sb.append(visit + " ");
        for(int i : list.get(visit)) {
            dfs(i);
        }
    }
    public static void bfs(int visit) {
        if(visited2[visit]) return;
        visited2[visit] = true;
        sb2.append(visit + " ");
        for(int i: list.get(visit)) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            bfs(queue.poll());
        }
    }
}

