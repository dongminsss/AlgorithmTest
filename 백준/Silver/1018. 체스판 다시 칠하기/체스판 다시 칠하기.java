
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];

        for(int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            board[i] = line;
        }
        int answer = Integer.MAX_VALUE;

        char[][] whiteStartBoard = new char[8][8];
        char[][] blackStartBoard = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(i % 2 == 0 && j % 2 == 0) {
                    whiteStartBoard[i][j] = 'W';
                    blackStartBoard[i][j] = 'B';
                } else if(i % 2 == 0 && j % 2 == 1) {
                    whiteStartBoard[i][j] = 'B';
                    blackStartBoard[i][j] = 'W';
                } else if(i % 2 == 1 && j % 2 == 0) {
                    whiteStartBoard[i][j] = 'B';
                    blackStartBoard[i][j] = 'W';
                } else {
                    whiteStartBoard[i][j] = 'W';
                    blackStartBoard[i][j] = 'B';
                }
            }
        }

        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {
                int count1 = 0;
                int count2 = 0;
                for(int k = i; k < 8 + i; k++) {
                    for(int l = j; l < 8 + j; l++) {
                        if(board[k][l] != whiteStartBoard[k - i][l - j]) count1++;
                        if(board[k][l] != blackStartBoard[k - i][l - j]) count2++;
                    }
                }
                answer = Math.min(answer, count1);
                answer = Math.min(answer, count2);

            }
        }
        System.out.println(answer);

    }
}