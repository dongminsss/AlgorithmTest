
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int count = 0;
        int answer = 1;
        V = V - A;
        answer += V / (A - B);
        if (V % (A - B) > 0) answer++;

        System.out.println(answer);
    }
}