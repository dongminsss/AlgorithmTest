import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayDeque<HashMap<Integer, Integer>> queue = new ArrayDeque<>();
            int count = Integer.parseInt(st.nextToken());
            int order = Integer.parseInt(st.nextToken());
            int[] arr = new int[count];
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < count; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(j, arr[j]);
                queue.offer(map);
            }
            int[] sortArr = arr.clone();
            Arrays.sort(sortArr);
            int k = sortArr.length - 1;
            int sequence = 0;
            while (!queue.isEmpty()) {
                HashMap<Integer, Integer> map = queue.poll();
                if(!map.containsValue(sortArr[k])) {
                    queue.offer(map);
                } else {
                    sequence++;
                    k--;
                    if(map.containsKey(order)) {
                        System.out.println(sequence);
                        break;
                    }
                }

            }

        }

    }
}