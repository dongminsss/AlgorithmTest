
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int xNum = 1;
        int yNum = 1;

        for(int i = 1; i < n; i++) {
            if(count % 2 == 0) {
                if(xNum <= count) xNum++;
                if(yNum > 1) yNum--;
                if(xNum > count) count++;
            } else {
                if(yNum <= count) yNum++;
                if(xNum > 1) xNum--;
                if(yNum > count) count++;
            }
        }

        System.out.println(xNum +"/" + yNum);
    }
}