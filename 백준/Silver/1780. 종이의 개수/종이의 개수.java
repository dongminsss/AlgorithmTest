import java.io.*;
import java.util.*;

public class Main {
    static int[] count = new int[3];  // -1, 0, 1을 카운팅

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPaper(paper, 0, 0, N);
        System.out.println(count[0]); 
        System.out.println(count[1]); 
        System.out.println(count[2]); 
    }

    static void countPaper(int[][] paper, int x, int y, int size) {
        if (checkSame(paper, x, y, size)) {
            count[paper[x][y] + 1]++; 
        } else {
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    countPaper(paper, x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }

    static boolean checkSame(int[][] paper, int x, int y, int size) {
        int num = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
