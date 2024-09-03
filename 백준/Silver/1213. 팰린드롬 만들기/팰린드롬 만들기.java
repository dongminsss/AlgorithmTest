import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] charCount = new int[26];  // 알파벳 개수만큼 배열 생성

        // 각 문자 개수 카운트
        for (char c : input.toCharArray()) {
            charCount[c - 'A']++;
        }

        int oddCount = 0;  // 홀수 개수의 문자 개수
        char middleChar = 0;  // 가운데에 올 홀수 문자
        StringBuilder frontPart = new StringBuilder();
        StringBuilder backPart = new StringBuilder();

        // 홀수 개수 문자 찾기
        for (int i = 0; i < 26; i++) {
            if (charCount[i] % 2 == 1) {
                oddCount++;
                middleChar = (char) (i + 'A');
            }
            // 짝수 개수 문자 나누기
            for (int j = 0; j < charCount[i] / 2; j++) {
                frontPart.append((char) (i + 'A'));
            }
        }

        // 홀수 개수의 문자가 2개 이상인 경우 팰린드롬 불가
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 뒷부분은 앞부분을 뒤집은 것
        backPart.append(frontPart).reverse();

        // 최종 결과 만들기
        StringBuilder result = new StringBuilder();
        result.append(frontPart);
        if (middleChar != 0) {
            result.append(middleChar);  // 홀수 문자가 있으면 가운데 추가
        }
        result.append(backPart);

        // 결과 출력
        System.out.println(result);
    }
}
