
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int e = 1;
        int s = 1;
        int m = 1;
        int count = 1;
        while (true) {
            if(e == E  && s == S && m == M) break;

            if( e >= 15) {
                e = 1;
            } else {
                e++;
            }

            if(s >= 28) {
                s = 1;
            } else {
                s++;
            }

            if(m >= 19) {
                m = 1;
            } else {
                m++;
            }
            count++;

        }
        System.out.println(count);
    }
}