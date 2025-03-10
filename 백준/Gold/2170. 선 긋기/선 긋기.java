import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        List<int[]> lines = new ArrayList<>();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines.add(new int[]{start, end});
        }
        lines.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int start = lines.get(0)[0];
        int end = lines.get(0)[1];
        int answer = 0;
        for(int[] line : lines) {
            if(line[0] <= end) {
                end = Math.max(end, line[1]);
            } else {
                answer += (end - start);
                start = line[0];
                end = line[1];
            }
        }
        answer += (end - start);
        System.out.println(answer);

    }
}
