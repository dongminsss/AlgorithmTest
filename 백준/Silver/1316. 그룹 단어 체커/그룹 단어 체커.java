
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char[] cArr = input.next().toCharArray();
            boolean flag = true;
            char[] mark = new char[cArr.length];

            mark[0] = cArr[0];
            for(int j = 1; j < cArr.length; j++) {
                if(cArr[j] != cArr[j-1]) {
                    if(search(mark, cArr[j])) {
                        flag = false;
                        break;
                    } else {
                        mark[j] = cArr[j];
                    }
                }
            }
            if(flag) count++;

        }
        System.out.println(count);
    }

    private static boolean search(char[] arr, char target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return true;
        }
        return false;
    }
}