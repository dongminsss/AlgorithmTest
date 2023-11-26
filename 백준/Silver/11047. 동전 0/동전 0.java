import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int coin = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] arr = new int[length];
        for(int i = 0; i<length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = length-1; i>-1; i--) {
            int n = coin / arr[i];
            coin = coin % arr[i];
            count += n;
        }
        System.out.println(count);
    }
}