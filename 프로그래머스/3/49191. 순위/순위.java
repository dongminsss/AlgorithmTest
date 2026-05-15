import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1];
        for(int[] arr : results) {
            int n1 = arr[0];
            int n2 = arr[1];
            graph[n1][n2] = true;
        }
        
        for(int k = 1; k<=n; k++) {
            for(int i = 1; i<=n; i++) {
                for(int j = 1; j<=n; j++) {
                    if(graph[i][k] && graph[k][j]) graph[i][j] = true;
                }
            }
        }
        
        for(int i = 1; i<=n; i++) {
            int count = 0;
            for(int k = 1; k<=n; k++) {
                if(graph[i][k]) count++;
            }
            for(int k = n; k > 0; k--) {
                if(graph[k][i]) count++;
            }
            if(count == n-1) answer++;
        }
        return answer;
    }
}