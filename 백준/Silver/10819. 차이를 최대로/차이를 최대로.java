
import java.util.*;
import java.io.*;

public class Main {
    static int maxResult = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(new ArrayList<>());
        System.out.println(maxResult);
    }

    private static void solve(List<Integer> current) {
        if(current.size() == n){
            maxResult = Math.max(maxResult, cal(current));
            return;
        }

        for(int i = 0; i<n; i++) {
            if(!visited[i]){
                visited[i] = true;
                current.add(arr[i]);
                solve(current);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }

    }

    private static int cal(List<Integer> list) {
        int sum = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            sum += Math.abs(list.get(i) - list.get(i + 1));
        }
        return sum;
    }
}