import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> network;
    public int solution(int n, int[][] computers) {
        network = new ArrayList<>();
        visited = new boolean[n];
        for(int i = 0; i<n; i++) {
            network.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(i != j && computers[i][j] == 1) {
                    network.get(i).add(j);
                    network.get(j).add(i);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i<n; i++) {
            answer += dfs(i);
        }
        return answer;
    }
    public static int dfs (int node) {
        if(visited[node]) return 0;
        visited[node] = true;
        for(Integer i : network.get(node)) {
            dfs(i);
        }
        return 1;
    }
}