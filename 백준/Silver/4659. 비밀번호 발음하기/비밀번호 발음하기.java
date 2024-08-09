import java.io.*;
import java.util.*;

public class Main {
    static char[] aeiou = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while (true) {
            str = br.readLine();
            if(str.equals("end")) break;
            if(vowel(str) && wordThreeSequence(str) && twoWordSequence(str)) {
                System.out.println("<" + str + ">" + " is acceptable.");
            } else {
                System.out.println("<" + str + ">" + " is not acceptable.");
            }
        }

    }

    static boolean vowel(String word) {
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o') {
                return true;
            }
        }
        return false;
    }

    static boolean wordThreeSequence(String word) {
        for(int i = 0; i < word.length()-2; i++) {
            int vowelCount = 0;
            for(char c : aeiou) {
                if(word.charAt(i) == c) vowelCount++;
                if(word.charAt(i+1) == c) vowelCount++;
                if(word.charAt(i+2) == c) vowelCount++;
            }
            if(vowelCount == 3 || vowelCount == 0) return false;
        }
        return true;
    }

    static boolean twoWordSequence(String word) {

        for(int i = 0; i < word.length()-1; i++) {
            String word2 = word.substring(i, i+2);
            if(!word2.equals("ee") && !word2.equals("oo")) {
                if(word2.charAt(0) == word2.charAt(1)) return false;
            }
        }
        return true;
    }
}
