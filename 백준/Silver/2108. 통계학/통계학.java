
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }
        Arrays.sort(arr);

        double sum = 0;
        for (int a : arr) {
            sum += a;
        }

        System.out.println(Math.round(sum / n));
        System.out.println(arr[n / 2]);

        int max = 0;
        List<Integer> list = new ArrayList<>();

        for(Integer key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) list.add(key);
        }

        if(list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            list.sort(null);
            System.out.println(list.get(1));
        }



        System.out.println(arr[arr.length - 1] - arr[0]);
    }
}