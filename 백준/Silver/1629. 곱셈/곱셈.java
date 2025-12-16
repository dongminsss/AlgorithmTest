import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        System.out.println(pow(n % d, m));
    }

    private static long pow(long base, long k) {
        if(k == 1) {
            return base % d;
        }

        long temp = pow(base, k / 2);

        long result = (temp * temp) % d;
        if(k % 2 == 1) {
            result = (result * base) % d;
        }
        return result;
    }
}