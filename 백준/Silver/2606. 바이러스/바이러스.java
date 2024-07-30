import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayDeque<Integer> queue = new ArrayDeque<>();
    static ArrayList<ArrayList<Integer>> computer = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNumber = Integer.parseInt(br.readLine());
        for(int i = 0; i < computerNumber + 1; i++) {
            computer.add(new ArrayList<>());
        }
        visited = new boolean[computerNumber + 1];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            computer.get(node).add(edge);
            computer.get(edge).add(node);
        }
        bfs(1);
        System.out.println(count);

    }

    public static void bfs(int start) {
        if(!visited[start]) {
            visited[start] = true;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for(int nextNode : computer.get(node)) {
                    if(!visited[nextNode]) {
                        visited[nextNode] = true;
                        queue.offer(nextNode);
                        count++;
                    }
                }
            }
        }
    }
}