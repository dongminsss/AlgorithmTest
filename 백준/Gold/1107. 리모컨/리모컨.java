import java.io.*;
import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10]; // 고장난 버튼 표시

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());   // 이동하려는 채널
        int M = Integer.parseInt(br.readLine());   // 고장난 버튼 개수

        // 고장난 버튼 정보를 boolean 배열에 저장
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int btn = Integer.parseInt(st.nextToken());
                broken[btn] = true;
            }
        }

        // 1) +/- 로만 이동하는 경우
        int answer = Math.abs(N - 100);

        // 2) 0 ~ 999,999까지 직접 눌러서 이동하는 경우 검사
        for (int i = 0; i <= 999999; i++) {
            if (isPossible(i)) {
                int clickCount = String.valueOf(i).length(); // 숫자를 누르는 횟수
                int pressCount = Math.abs(N - i);            // +/- 로 이동하는 횟수
                answer = Math.min(answer, clickCount + pressCount);
            }
        }

        System.out.println(answer);
    }

    // 숫자 x를 누를 수 있으면 true, 없으면 false
    private static boolean isPossible(int x) {
        // x가 0인 경우 체크
        if (x == 0) {
            return !broken[0];
        }
        // x가 0이 아닐 때 각 자리수를 확인
        while (x > 0) {
            int digit = x % 10;
            if (broken[digit]) {
                return false;
            }
            x /= 10;
        }
        return true;
    }
}
