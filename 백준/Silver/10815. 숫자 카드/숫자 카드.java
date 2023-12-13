import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[length];
        for(int i = 0; i<length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cardNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cardNumber; i++) {
            int temp = Arrays.binarySearch(arr, Integer.parseInt(st.nextToken()));
            if(temp <0) {
                sb.append(0).append(" ");
            } else {
                sb.append(1).append(" ");
            }
        }
        System.out.println(sb);
    }

}
