import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {       
        int[] answer = new int[sources.length];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;
        for(int i = 0; i<n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        dq.offer(destination);
        while(!dq.isEmpty()) {
            int current = dq.poll();
            for(int next : graph.get(current)) {
                if(dist[next] == -1) {
                    dq.offer(next);
                    dist[next] = dist[current] + 1;
                }
            }
        }
        for(int i = 0; i<sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
}