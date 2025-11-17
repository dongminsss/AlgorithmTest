import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        int count = 1;
        for(int i = 0; i<n; i++) {
            String str = br.readLine();
            map.put(str , count);
            map2.put(String.valueOf(count) , str);
            count++;
        }

        for(int i = 0; i<m; i++) {
            String ball = br.readLine();
            if(map.get(ball) == null) {
                System.out.println(map2.get(ball));
            } else {
                System.out.println(map.get(ball));
            }
        }
    }

//    public static boolean isNumber(String s) {
//        for(char c : s.toCharArray()) {
//            if(!Character.isDigit(c)) return false;
//        }
//        return true;
//    }
}
