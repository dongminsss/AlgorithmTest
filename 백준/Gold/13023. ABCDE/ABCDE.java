import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<ArrayList<Integer>> list;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        visited = new boolean[nodeCount];
        for(int i = 0; i<nodeCount; i++) {
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

        for(int i = 0; i<list.size(); i++) {
            dfs(i,1);
            if(arrive) break;
        }
        if(arrive){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int visit,int depth) {
        if(visited[visit]) return;
        if(depth == 5 || arrive) {
            arrive =true;
            return;
        }
        visited[visit] = true;
        for(int i : list.get(visit)) {
            dfs(i, depth+1);
        }
        visited[visit] = false;
    }
}

