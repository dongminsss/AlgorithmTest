import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 1; i <=N; i++) {
            int count = Integer.parseInt(st.nextToken());
            int index = 0;
            if(i == 1) {
                arr[count] = i;
            } else {
                for(int j = 0; j < N; j++) {
                    if(count == 0) {
                        index = j;
                        break;
                    }
                    if(arr[j] == 0) count--;
                }
                for(int j = index; j < N; j++) {
                    if(arr[j] == 0) {
                        arr[j] = i;
                        break;
                    }
                }
            }
        }
        String result = "";
        for (int i : arr) {
            result += i + " ";
        }
        System.out.println(result.trim());

    }
}
