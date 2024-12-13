
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        while (true) {
            if(!input.hasNextLine()) break;
            String n = input.nextLine();

            if(n.equals("0")) break;
            
            StringBuilder sb = new StringBuilder(n);
            String s = sb.reverse().toString();
            if(s.equals(n)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }

    }
}