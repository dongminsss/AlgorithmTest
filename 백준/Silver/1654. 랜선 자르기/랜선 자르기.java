import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken()); // 랜선의 개수 K
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수 N
        int[] lanCables = new int[K];
        for (int i = 0; i < K; i++) {
            lanCables[i] = Integer.parseInt(br.readLine()); // 랜선 길이 입력
        }
        
        System.out.println(binarySearch(lanCables, N));
    }

    public static long binarySearch(int[] cables, int target) {
        long max = 0;
        for (int cable : cables) {
            max = Math.max(max, cable);
        }
        
        long start = 1;
        long end = max;
        long result = 0;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int cable : cables) {
                count += (cable / mid);
            }

            if (count < target) {
                end = mid - 1;
            } else {
                result = mid; // 조건을 만족하는 경우 결과 업데이트
                start = mid + 1;
            }
        }
        return result;
    }
}
