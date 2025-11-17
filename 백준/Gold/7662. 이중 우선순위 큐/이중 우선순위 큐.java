import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++) {
            int m = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                Integer number = Integer.parseInt(st.nextToken());
                switch (cmd) {
                    case "I":
                        map.put(number, map.getOrDefault(number, 0) + 1);
                        break;
                    case "D":
                        if(!map.isEmpty()) {
                            if(number == -1) {
                                int min = map.firstKey();
                                if(map.get(min) == 1) {
                                    map.remove(min);
                                } else {
                                    map.put(min , map.get(min) -1);
                                }
                            }
                            if(number == 1) {
                                int max = map.lastKey();
                                if(map.get(max) == 1) {
                                    map.remove(max);
                                } else {
                                    map.put(max, map.get(max) - 1);
                                }
                            }
                        }
                        break;
                }

            }
            if(map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());

            }
        }
    }
}
