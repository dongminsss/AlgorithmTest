import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] charArr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String dna = br.readLine();
            char[] charArray = dna.toCharArray();
            charArr[i] = charArray;
        }
        makeDna(charArr);
    }

    static void makeDna(char[][] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr[0].length; i++) {
            TreeMap<Character, Integer> map = new TreeMap<>();
            for (int j = 0; j < arr.length; j++) {
                char ch = arr[j][i];
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            char mostChar = map.firstKey();
            int maxCount = map.get(mostChar);
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if(entry.getValue() > maxCount) {
                    mostChar = entry.getKey();
                    maxCount = entry.getValue();
                }
            }
            sb.append(mostChar);
        }
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += calHamingDistance(sb.toString(), new String(arr[i]));
        }
        System.out.println(sb);
        System.out.println(total);
    }

    static int calHamingDistance(String s1, String s2) {
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}