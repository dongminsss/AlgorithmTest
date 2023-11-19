import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> list;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int result = 0;
        visited = new boolean[nodeCount+1];
        list = new ArrayList<>();
        for(int i = 0; i<nodeCount+1; i++) {
            List<Integer> nodeEdge = new ArrayList<>();
            list.add(nodeEdge);
        }
        for(int i = 0; i<edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            list.get(node).add(edge);
            list.get(edge).add(node);
        }
        for(int i = 1; i<nodeCount+1; i++) {
            if(!visited[i]) {
                result++;
                dfs(i);
            }
        }
        System.out.println(result);

    }
    public static void dfs(int v) {
        if(visited[v]) return;
        visited[v] = true;
        for(int i : list.get(v)) {
            if(!visited[i]) dfs(i);
        }
    }
}
