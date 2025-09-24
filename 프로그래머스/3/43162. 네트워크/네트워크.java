import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> network = new ArrayList<>();
    static boolean[] v;
    
    public int solution(int n, int[][] computers) {
        v = new boolean[n];
        
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
        
        int answer = 0;
        
        for(int i = 0; i<n; i++) {
            answer += dfs(i);
        }
        return answer;
    }
    
    private int dfs(int idx) {
        if(v[idx]) return 0;
        v[idx] = true;
        for(int computer : network.get(idx)) {
            dfs(computer);
        }
        return 1;
    }
}