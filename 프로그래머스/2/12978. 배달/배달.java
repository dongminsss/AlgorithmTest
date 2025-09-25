import java.util.*;

class Solution {
    static int[] dist;
    static ArrayList<ArrayList<int[]>> nodes = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i<N+1; i++) {
            nodes.add(new ArrayList<>());
        }
        for(int[] arr : road) {
            nodes.get(arr[0]).add(new int[] {arr[1], arr[2]});
            nodes.get(arr[1]).add(new int[] {arr[0], arr[2]});
        }
        
        dist[1] = 0;
        dfs(1);
        
        
        for(int len : dist) {
            if(len <= K) answer++;
        }
        
        System.out.println(Arrays.toString(dist));
        
        return answer;
    }
    
    private void dfs(int node) {
        for(int[] arr : nodes.get(node)) {
            int nDist =dist[node] + arr[1];
            int nNode = arr[0];
            
            if(dist[nNode] > nDist) {
                dist[nNode] = nDist;
                dfs(nNode);
            }
        }
    }
}