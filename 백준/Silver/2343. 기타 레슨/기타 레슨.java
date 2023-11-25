import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int bluelay = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        int sum = 0;
        int start = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(start < arr[i]) start = arr[i];
            sum += arr[i];
        }
        int end = sum;
        while (start <= end) {
            int count = 1;
            int middle = (start + end) / 2;
            int temp = 0;
            for(int j = 0; j<length; j++) {
                if (temp + arr[j] > middle) {
                    temp = 0;
                    count++;
                }
                temp += arr[j];
            }
            if(count <= bluelay) {
                end = middle -1;
            }  else {
                start = middle + 1;
            }
        }
        System.out.println(start);
    }
}