import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PrimMST graph = new PrimMST(n);
        
        for(int[] cost : costs) {
            graph.addEdge(cost[0],cost[1],cost[2]);
        }
        
        
        
        return graph.findPrimMST();
    }
}

class PrimMST {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    private int V;
    private List<List<Edge>> adj;

    public PrimMST(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Edge(src, dest, weight));
        adj.get(dest).add(new Edge(dest, src, weight));
    }

    public int findPrimMST() {
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(edge -> edge.weight));
        List<Edge> mst = new ArrayList<>();
        
        visited[0] = true;
        pq.addAll(adj.get(0));
        
        while (!pq.isEmpty() && mst.size() < V - 1) {
            Edge edge = pq.poll();
            
            if(!visited[edge.dest]) {
                mst.add(edge);
                visited[edge.dest] = true;
                
                for(Edge e : adj.get(edge.dest)) {
                    if(!visited[e.dest]) {
                        pq.add(e);
                    }
                }
            }
        }
        int totalWeight = 0;
        for(Edge edge : mst) {
            totalWeight += edge.weight;
        }
        return totalWeight;
    }
}