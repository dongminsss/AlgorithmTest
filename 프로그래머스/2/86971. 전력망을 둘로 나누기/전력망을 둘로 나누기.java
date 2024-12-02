import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> staticWires = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        
        for(int i = 0; i<n; i++) {
            staticWires.add(new ArrayList<>());
        }
        for(int[] arr : wires) {
            staticWires.get(arr[0]-1).add(arr[1]-1);
            staticWires.get(arr[1]-1).add(arr[0]-1);
        }
        
        for(int i = 0; i<n-1; i++) {
            visited = new boolean[n];
            int count = 0;
            
            int start = wires[i][0] - 1;
            int end = wires[i][1] - 1;
            dfs(start,end);
            
            
            for(boolean b : visited) {
                if(b) count++;
            }
            int sum = Math.abs( count - (n - count));
            
            min = Math.min(min, sum);
        }
        
        int answer = min;
        return answer;
    }
    
    private static void dfs(int avoid, int current) {
        if(visited[current]) return;
        visited[current] = true;
        
        for(Integer point : staticWires.get(current)) {
            if(point == avoid) continue;
            dfs(avoid, point);
        }
        
    }
}