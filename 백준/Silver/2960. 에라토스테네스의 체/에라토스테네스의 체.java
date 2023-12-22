import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        int[] countArr = new int[length];
        int result = 0;
        for(int i = 0; i<length; i++) {
            arr[i] = i+1;
            countArr[i] = i+1;
        }
        for(int i = 1; i<length; i++) {
            if(arr[i] != 0 ) {
                int temp = arr[i];
                for (int j = i + temp; j < length; j = j + temp) {
                    arr[j] = 0;
                }
            }
        }
        for(int i = 1; i<length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                for (int j = i; j < length; j= j+ temp) {
                    if(countArr[j] != 0) {
                        result++;
                        if(result == count) {
                            System.out.println(countArr[j]);
                            return;
                        }
                        countArr[j] = 0;
                    }
                }
            }

        }
    }
}