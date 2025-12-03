import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int total = 1;
        int result = 0;
        for(int i = 0; i<n; i++) {
            total *= 2;
        }
        total *= total;
        while (total >= 4) {
            int len = (int)Math.sqrt(total);
            int half = len / 2;
            int sum = total / 4;
            if(r < half && c < half) {
                result += 0;
            } else if(r < half) {
                result += sum;
            } else if (c < half) {
                result += sum * 2;
            } else {
                result += sum * 3;
            }
            r %= (len / 2);
            c %= (len / 2);
            total /= 4;
        }
        System.out.println(result);
    }
}