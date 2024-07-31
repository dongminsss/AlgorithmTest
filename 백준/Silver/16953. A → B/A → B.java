import java.io.*;
import java.util.*;

public class Main {
    static long end;
    static int count = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Long.parseLong(st.nextToken());
        dfs(start, 1);

        if(count == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }

    }

    static void dfs(long start, int depth) {
        if(end < start) return;

        if(end == start) {
            count = Math.min(count, depth);
            return;
        } else {
            String str = String.valueOf(start);
            str = str + "1";
            dfs(Long.parseLong(str), depth + 1);
            dfs(start  * 2, depth + 1);
        }
    }
}