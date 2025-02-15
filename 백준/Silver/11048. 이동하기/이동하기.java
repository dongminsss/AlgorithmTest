import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = matrix[0][0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = matrix[i][0] + dp[i-1][0];
        }
        for(int j = 1; j < m; j++) {
            dp[0][j] = matrix[0][j] + dp[0][j-1];
        }

        for(int i = 1; i<matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }
        System.out.println(dp[n-1][m-1]);

    }
}