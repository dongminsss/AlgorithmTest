
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = Integer.parseInt(str[j]);
            }
        }
        int flipCount = 0;
        for (int i = 0; i <= n-3; i++) {
            for (int j = 0; j <= m-3; j++) {
                if(matrixA[i][j] != matrixB[i][j]) {
                    flipCount++;
                    flip(matrixA, i ,j);
                }
            }
        }

        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrixA[i][j] != matrixB[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if(isSame) {
            System.out.println(flipCount);
        } else {
            System.out.println(-1);
        }


    }

    private static void flip(int[][] matrix, int x, int y) {
        for(int i = x; i < x+3; i++) {
            for(int j = y; j < y+3; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
    }
}