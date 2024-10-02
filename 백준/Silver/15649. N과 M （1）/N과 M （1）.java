
import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int[] numbers;
    static int length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        numbers = new int[n];
        length = m;
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        solve(new ArrayList<>());

    }

    private static void solve(List<Integer> current) {
        if(current.size() == length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(current.get(i) + " ");
            }
            System.out.println(sb.toString().trim());
            return;
        }
        for(int i =  0; i < numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current.add(numbers[i]);
                solve(current);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}