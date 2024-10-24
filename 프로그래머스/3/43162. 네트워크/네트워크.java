import java.util.*;
class Solution {
    static boolean[] visited;
    static int[][] network;
    static int count;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        network = computers;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }   
        }
        int answer = count;
        return answer;
    }
    
    private static void dfs(int computer) {
        if(visited[computer]) return;
        
        visited[computer] = true;
        
        for(int i = 0; i < network[computer].length; i++) {
            if(network[computer][i] != 0 && computer != i) dfs( i);
        }
        
        
    }
}