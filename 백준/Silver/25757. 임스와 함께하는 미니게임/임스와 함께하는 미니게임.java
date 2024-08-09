import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int people = 0;
        if(game.equals("Y")) {
            people = 1;
        } else if(game.equals("F")) {
            people = 2;
        } else {
            people = 3;
        }
        for(int i = 0; i < N; i++) {

            set.add(br.readLine());

        }
        System.out.println(set.size() / people);


    }
}
