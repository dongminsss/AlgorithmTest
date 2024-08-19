import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String searchStr = br.readLine();
        int result = 0;
        int index = 0;
        while ((index = str.indexOf(searchStr, index)) != -1) {
            result++;
            index += searchStr.length();  
        }

        System.out.println(result);

    }
}
