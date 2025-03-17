import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            treeSet.add(number);
            arr[i] = number;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int number : treeSet) {
            map.put(number, idx++);
        }
        StringBuilder sb = new StringBuilder();
        for(int number : arr) {
            sb.append(map.get(number)).append(" ");
        }
        System.out.println(sb.toString().trim());

    }

}