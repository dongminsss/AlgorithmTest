import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];
        for(int i = 0; i<arr.length; i++) {
            arr[i] = i;
        }
        arr[1] = 0;
        for(int i = 2; i< arr.length; i++) {
            if(arr[i] == 0) continue;
            for(int j = i+i; j<arr.length; j+=i) {
                arr[j] = 0;
            }
        }
        while (true) {
            if(arr[number] != 0) {
                if(palindromNumber(Integer.toString(arr[number]))){
                    System.out.println(number);
                    break;
                }
            }
            number++;
        }

    }
    public static boolean palindromNumber(String number) {
        int startIndex = 0;
        int endIndex = number.length() - 1;
        while (startIndex < endIndex) {
            if(number.charAt(startIndex) == number.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                return false;
            }
        }
        return true;
    }
}
