import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int heightPlus = Integer.parseInt(st.nextToken());
        int widthPlus = Integer.parseInt(st.nextToken());
        int n = 1 + heightPlus;
        int m = 1+ widthPlus;
        int people = height % n == 0 ? height / n : height / n + 1;
        int count = width % m == 0? width/ m : width / m + 1;
        System.out.println(people * count);
    }
}