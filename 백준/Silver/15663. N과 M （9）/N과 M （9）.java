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

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int val : output) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1; // 이 레벨(depth)에서 직전에 골랐던 숫자를 기억

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 직전에 고른 값과 지금 고를 값이 같으면 중복된 수열이 만들어지므로 패스
                if (before == arr[i]) {
                    continue;
                }

                before = arr[i]; // 현재 값을 before에 기록
                visited[i] = true;
                output[depth] = arr[i];

                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}
