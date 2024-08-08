import java.io.*;
import java.util.*;

public class Main {
    static int[] count = new int[3];  // -1, 0, 1을 카운팅

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int searchCountry = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken()) * 3;
            int silver = Integer.parseInt(st.nextToken()) * 2;
            int bronze = Integer.parseInt(st.nextToken());
            map.put(country, gold + silver + bronze);
            arr[i] = gold + silver + bronze;
        }
        Arrays.sort(arr);
        int count = 1;
        int prev = -1;
        for(int i = arr.length -1 ; i >= 0; i--) {
            int count2 = 0;
            for (Integer key : map.keySet()) {
                if(arr[i] == map.get(key) && prev != map.get(key)) {
                    rank.put(key, count);
                    count2++;
                }
            }
            prev = arr[i];
            count = count + count2;

        }
        System.out.println(rank.get(searchCountry));

    }
}
