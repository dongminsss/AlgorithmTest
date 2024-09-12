
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = br.readLine().toCharArray();
        }
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {
                minCount = Math.min(minCount, isValid(matrix, i, j));
            }
        }
        System.out.println(minCount);


    }

    private static int isValid(char[][] charArr, int row, int col) {

        int count1 = 0;
        int count2 = 0;
        char[][] validMatrix = {
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'}};

        char[][] validMatrix2 = {
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'}};
        for(int i = 0; i< 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(charArr[row + i][col + j] != validMatrix[i][j]) count1++;
                if(charArr[row + i][col + j] != validMatrix2[i][j]) count2++;
            }
        }

        return Math.min(count1, count2);
    }
}