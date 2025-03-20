import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        List<ArrayList<Integer>> node = new ArrayList<>();
        
        boolean[] visited = new boolean[n+1];
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        Map<Integer, Integer> table = new HashMap<>();
        for(int i = 0; i<=n; i++) {
            node.add(new ArrayList<>());
        }
        
        for(int[] nodes : edge) {
            node.get(nodes[0]).add(nodes[1]);
            node.get(nodes[1]).add(nodes[0]);
        }
        
        dq.offer(new int[]{1, 1});
        visited[1] = true;
        while(!dq.isEmpty()) {
            int[] info = dq.poll();
            int dqNode = info[0];
            int depth = info[1];
            
            table.put(depth, table.getOrDefault(depth,0) + 1);
            for(int nextNode : node.get(dqNode)) {
                if(!visited[nextNode]) {
                    dq.offer(new int[]{nextNode, depth+1});
                    visited[nextNode] = true;
                }
            }
        }
        int answer = 0;
        for(int i = 1; i <= 200000; i++) {
            if(table.containsKey(i)) {
                answer = table.get(i);
            }
        }       
        return answer;
    }
}