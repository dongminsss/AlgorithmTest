import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] numbers = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int white = searchPaperCount(0, numbers);
        int black = searchPaperCount(1, numbers);
        System.out.println(white);
        System.out.println(black);

    }

    static int searchPaperCount(int searchNumber, int[][] arr) {
        if(arr.length == 1) {
            return arr[0][0] == searchNumber ? 1 : 0;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != searchNumber) {
                    int zero = 0;
                    int middleLength = arr.length / 2;
                    return searchPaperCount(searchNumber, devideArray(arr, middleLength, zero, zero))
                            + searchPaperCount(searchNumber, devideArray(arr, middleLength, middleLength, middleLength))
                            + searchPaperCount(searchNumber, devideArray(arr, middleLength, middleLength, zero))
                            + searchPaperCount(searchNumber, devideArray(arr, middleLength, zero, middleLength));
                }
            }
        }

        return 1;
    }

    static int[][] devideArray(int[][] arr, int length, int widthStart, int heightStart) {
        if (length == 0) {
            return null;
        }
        int[][] newArr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                newArr[i][j] = arr[widthStart + i][heightStart + j];
            }
        }
        return newArr;
    }
}
