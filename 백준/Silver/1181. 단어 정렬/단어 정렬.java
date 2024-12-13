
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] sArr = new String[n];

        for(int i = 0; i < n; i++) {
            sArr[i] = br.readLine();
        }

        Arrays.sort(sArr, (o1, o2) -> {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });
        System.out.println(sArr[0]);
        for(int i = 1; i < sArr.length; i++) {
            if(!sArr[i].equals(sArr[i-1]) ) {
                System.out.println(sArr[i]);
            }
        }


    }
}