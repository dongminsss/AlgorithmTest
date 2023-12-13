import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[20000001];
        for(int i = 0; i<length; i++){
            arr[Integer.parseInt(st.nextToken()) + 10000000]++;
        }
        int cardNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cardNumber; i++) {
            sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
        }
        System.out.println(sb);
    }

}
