
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];

        // 단어 입력
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }


        int[] alphabetWeights = new int[26];

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();


            for (int j = 0; j < len; j++) {
                int charIndex = word.charAt(j) - 'A';
                alphabetWeights[charIndex] += Math.pow(10, len - j - 1);
            }
        }


        Integer[] weights = new Integer[26];
        for (int i = 0; i < 26; i++) {
            weights[i] = alphabetWeights[i];
        }


        Arrays.sort(weights, Collections.reverseOrder());

        int num = 9;
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (weights[i] == 0) break;
            result += weights[i] * num;
            num--;
        }


        System.out.println(result);

    }
}