import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[number+1];
        arr[1] = 0;
        for(int i = 2; i<=number; i++) {
            arr[i] = arr[i-1] + 1;
            if(i % 2 == 0) arr[i] = Math.min(arr[i], arr[i/2]+1);
            if(i % 3 == 0) arr[i] = Math.min(arr[i],arr[i/3] + 1);
        }
        System.out.println(arr[number]);
    }
}
