import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer mSt = new StringTokenizer(br.readLine());
        StringTokenizer arrSt = new StringTokenizer(br.readLine());
        int count = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(mSt.nextToken());

        int[] arr = new int[N];
        int startIndex = 0;
        int endIndex = arr.length-1;
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(arrSt.nextToken());
        }
        Arrays.sort(arr);
        while (endIndex != startIndex) {
            if(arr[startIndex] + arr[endIndex] < M) {
                startIndex++;
            } else if (arr[startIndex] + arr[endIndex] > M) {
                endIndex--;
            } else {
                endIndex--;
                count++;
            }
        }
        System.out.println(count);
    }
}