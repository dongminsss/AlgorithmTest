import java.util.*;

class Solution {
    private boolean[] visited;
    private List<List<Integer>> network = new ArrayList<>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i<n; i++) {
            network.add(new ArrayList<>());
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(i != j && computers[i][j] == 1) {
                    network.get(i).add(j);
                    network.get(j).add(i);
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                dfs(i);
            }
        }
        
        return answer;
    }
    
    private void dfs(int node) {
        
        for(int next : network.get(node)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}