import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prevIdx = 0;
        int max = 0;
        int[] tanghuru = new int[N];
        int[] fruitCount = new int[10];
        int type = 0;
        for(int i = 0; i<N; i++) {
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N; i++) {
            if(fruitCount[tanghuru[i]] == 0) type++;
            fruitCount[tanghuru[i]]++;

            while(type > 2) {
                fruitCount[tanghuru[prevIdx]]--;
                if(fruitCount[tanghuru[prevIdx]] == 0) type--;
                prevIdx++;
            }
            max = Math.max(max, i - prevIdx + 1);
        }

        System.out.println(max);
    }
}