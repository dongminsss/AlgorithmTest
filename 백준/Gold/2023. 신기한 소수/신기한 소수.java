import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    static int digit;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        digit = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }
    public static void dfs(int number, int n) {
        if(n == digit) {
            if(isPrime(number)) System.out.println(number);
        }

        for(int i = 1; i<10; i++) {
            if(i % 2 == 1 && isPrime(number * 10 + i)) dfs((number * 10) + i, n + 1);
        }
    }
    public static boolean isPrime(int number) {
        if(number <= 1) return false;
        for(int i = 2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
