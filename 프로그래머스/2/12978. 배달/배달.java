import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<int[]>> nodes = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 0; i<N+1; i++) {
            nodes.add(new ArrayList<>());
        }
        for(int[] r : road) {
            nodes.get(r[0]).add(new int[]{r[1] , r[2]});
            nodes.get(r[1]).add(new int[] {r[0], r[2]});
        }
        dist[1] = 0;
        pq.offer(new int[] {1, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if(dist[node] < cost) continue;
            
            for(int[] next : nodes.get(node)) {
                int nNode = next[0];
                int nCost = next[1] + cost;
                
                if(dist[nNode] > nCost) {
                    dist[nNode] = nCost;
                    pq.offer(new int[] {nNode, nCost});
                }
            }
        }
        for(int d : dist) {
            if(d <= K) answer++;
        }
        

        return answer;
    }
}