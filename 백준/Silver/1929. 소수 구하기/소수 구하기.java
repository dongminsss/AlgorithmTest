import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for(int i = start; i<=end; i++) {
            if(primeNumber(i)) System.out.println(i);
        }

    }
    public static boolean primeNumber(int number) {
        if(number == 0 || number == 1 ) return false;
        for(int i = 2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
