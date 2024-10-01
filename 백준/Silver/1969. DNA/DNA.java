
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String result = "";
        int numberResult = 0;
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            matrix[i] = str.toCharArray();
        }

        for(int i = 0; i < m; i++){

            int[] counts = new int[4];
            int targetIndex = 0;

            for(int j = 0; j < n; j++){
                char ch = matrix[j][i];
                if(ch == 'A'){
                    counts[0]++;
                } else if(ch == 'C'){
                    counts[1]++;
                } else if(ch == 'G'){
                    counts[2]++;
                } else {
                    counts[3]++;
                }
            }

            for(int j = 1; j < 4; j++){
                if(counts[j] > counts[targetIndex]){
                    targetIndex = j;
                }
            }
            for(int j = 0; j < 4; j++){
                if(targetIndex == j) {
                    continue;
                } else {
                    if(counts[j] > 0) numberResult += counts[j];
                }
            }

            if(targetIndex == 0) {
                result += "A";
            } else if(targetIndex == 1) {
                result += "C";
            } else if(targetIndex == 2) {
                result += "G";
            } else {
                result += "T";
            }



        }

        System.out.println(result);
        System.out.println(numberResult);

    }
}