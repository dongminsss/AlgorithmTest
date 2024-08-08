import java.io.*;
import java.util.*;

public class Main {
    static int[] count = new int[3];  // -1, 0, 1을 카운팅

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;

            for (int j = 0; j < 20; j++) {
                int number = Integer.parseInt(st.nextToken());
                list.add(number);
                int index = list.size()-2;

                while (index > -1) {
                    if(list.get(index) > number) {
                        count++;
                    } else {
                        break;
                    }
                    index--;
                }
                if(list.size() - 1 != index) {
                    list.remove(list.size()-1);
                    list.add(index + 1,number);
                }

            }
            System.out.print(T + " " + count +"\n");
        }
    }
}
