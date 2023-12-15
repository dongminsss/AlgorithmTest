import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[][] arr = new int[length][2];
        for( int i = 0; i< arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<arr.length; i++) {
            int count = 1;
            for(int j = 0; j<arr.length; j++) {
                if(i == j) {
                    continue;
                } else {
                    if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) count++;
                }
            }
            System.out.println(count);
        }
    }

}
