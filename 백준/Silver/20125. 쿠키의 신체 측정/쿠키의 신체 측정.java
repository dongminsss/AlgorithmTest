import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] matrix = new String[n][n];
        int leftArm = 0;
        int rightArm = 0;
        int middle = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int middleRow = 0;
        int middleCol = 0;
        int middleEnd = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            String[] input = br.readLine().split("");
            matrix[i] = input;
        }
        // 심장 위치 저장
        for(int i = 0; i < matrix.length; i++) {
            int count = 0;
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("*")) {
                    count++;
                    middleRow = j;
                    middleCol = i + 1;
                }
            }
            if(count == 1) break;
        }

        for(int i = 0; i < middleRow; i++) {
            if(matrix[middleCol][i].equals("*")) leftArm++;
        }

        for(int i = middleRow + 1; i < n; i++) {
            if(matrix[middleCol][i].equals("*")) rightArm++;
        }

        for(int i = middleCol + 1; i < n; i++) {
            if(matrix[i][middleRow].equals("*")) {
                middle++;
            } else {
                middleEnd = i;
                break;
            }
        }
        for(int i = middleEnd; i < n; i++) {
            if(matrix[i][middleRow-1].equals("*")) leftLeg++;
        }

        for (int i = middleEnd; i < n; i++) {
            if(matrix[i][middleRow+1].equals("*")) rightLeg++;
        }
        System.out.println(middleCol + 1 + " " + (middleRow + 1));
        System.out.println(leftArm + " " + rightArm + " " + middle + " " + leftLeg + " " + rightLeg);

    }
}
