import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;
        int len = 2*N+1;
        String IO = IOMake(N);
        for(int i = 0; i<=M-len; i++) {
            if(IO.equals(str.substring(i, i+len))) {
                count++;
            }
        }
        System.out.println(count);

    }

    private static String IOMake(int n) {
        StringBuilder sb = new StringBuilder();
        int length = 2 * n + 1;
        for(int i = 0; i<length; i++) {
            if(i % 2 == 0) {
                sb.append("I");
            } else {
                sb.append("O");
            }
        }
        return sb.toString();
    }
}