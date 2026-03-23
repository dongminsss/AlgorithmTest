import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){dq.add(i);}
        sb.append("<");

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<K-1; j++) {
                int a = dq.poll();
                dq.offer(a);
            }
            sb.append(dq.poll()).append(", ");
        }
        sb.delete(sb.length() - 2,sb.length()).append(">");
        System.out.println(sb);
        
    }
}