import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[length];

        for(int i = 0; i<length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int searchLength = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< searchLength; i++) {
            binarySearch(arr, Integer.parseInt(st.nextToken()));
        }

    }
    static void binarySearch(int[] sortedArr, int n) {
        int middle = sortedArr.length / 2;
        int startIndex = 0;
        int endIndex = sortedArr.length -1;
        while (startIndex <= endIndex ) {
            if( n < sortedArr[middle]) {
                endIndex = middle - 1;
            } else if (n > sortedArr[middle]) {
                startIndex = middle + 1;
            } else {
                System.out.println(1);
                return;
            }
            middle = (startIndex + endIndex) / 2;
        }
        System.out.println(0);
    }
}
