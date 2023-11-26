import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int result = 0;
        int count = 0;
        int plus = 1;
        while (true) {
            if(number <= plus) {
                break;
            } else {
                count++;
                plus += 6 * count;
            }
        }
        System.out.println(count+1);
    }
}