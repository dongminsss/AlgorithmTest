import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 1;
        int sum = 1;
        int N = Integer.parseInt(st.nextToken());
        int startIndex = 1;
        int endIndex = 1;
        while(endIndex != N) {
            if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else if (sum > N) {
                sum -= startIndex++;
            } else {
                count++;
                sum += ++endIndex;
            }
        }
        System.out.println(count);

    }
}