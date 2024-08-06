import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        String[] exitOrder = new String[n];
        for (int i = 0; i < n; i++) {
            String carNumber = br.readLine();
            map.put(carNumber, i);
        }

        for (int i = 0; i < n; i++) {
            exitOrder[i] = br.readLine();
        }

        int start = 0;
        int count = 0;
        HashSet<Integer> checked = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int index = map.get(exitOrder[i]);
            if (index != start) {
                count++;
            }
            checked.add(index);
            while (checked.contains(start)) {
                start++;
            }
        }
        System.out.println(count);
    }
}