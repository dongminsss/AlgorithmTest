import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        List<int[]> points = new ArrayList<>();
        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            points.add(new int[]{start, end});
        }

        points.sort((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int count = 0;
        int endTime = 0;
        for(int[] a : points) {
            if(endTime <= a[0]) {
                endTime = a[1];
                count++;
            }
        }
        System.out.println(count);
    }
}
