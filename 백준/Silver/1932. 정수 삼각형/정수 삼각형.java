import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> triangle = new ArrayList<>();
        List<int[]> memo = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[i+1];
            memo.add(a);
            for(int j = 0; j < i+1; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            triangle.add(a);
        }

        memo.get(0)[0] = triangle.get(0)[0];

        for(int i = 1; i < triangle.size(); i++) {
            int[] prevB = memo.get(i-1);
            int[] a = triangle.get(i);
            int[] b = memo.get(i);

            for(int j = 0; j < a.length; j++) {
                if(j == 0) {
                    b[j] = a[j] + prevB[j];
                } else if (j == a.length - 1) {
                    b[j] = a[j] + prevB[j-1];
                } else {
                    b[j] = a[j] + Math.max(prevB[j], prevB[j-1]);
                }
            }

        }
        int answer = 0;
        for(int number : memo.get(memo.size()-1)) {
            answer = Math.max(answer, number);
        }
        System.out.println(answer);


    }

}
