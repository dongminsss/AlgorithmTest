import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        output = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int idx) {
        if (depth == m) {
            for (int val : output) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;

        for (int i = idx; i < n; i++) {

            if (before == arr[i]) {
                continue;
            }
            before = arr[i];
            output[depth] = arr[i];
            dfs(depth + 1, i);

        }

    }
}
