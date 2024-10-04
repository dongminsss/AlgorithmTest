
import java.util.*;
import java.io.*;

public class Main {
    static int[][] scoreMatrix;
    static int length;
    static boolean[] visited;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        scoreMatrix = new int[n][n];
        length = n;
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                scoreMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0);
        System.out.println(minValue);
    }

    static void solve (int index, int depth) {
        if (depth == length / 2) {
            cal();
            return;
        }

        for (int i = index; i< length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solve(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void cal() {
        int startTeam = 0;
        int linkTeam = 0;
        for(int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j <length; j++) {
                if(visited[i] && visited[j]) {
                    startTeam += scoreMatrix[i][j];
                    startTeam += scoreMatrix[j][i];
                }
                if(visited[i] == false && visited[j] == false) {
                    linkTeam += scoreMatrix[i][j];
                    linkTeam += scoreMatrix[j][i];
                }
            }
        }
        minValue = Math.min(minValue, Math.abs(startTeam - linkTeam));
    }
}