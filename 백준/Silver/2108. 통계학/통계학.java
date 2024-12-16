
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        int answer4 = 0;

        for(int i : numbers) {
            answer1 += i;
        }
        answer1 = (int)Math.round((double) answer1 / n);
        System.out.println(answer1);

        Arrays.sort(numbers);
        answer2 = numbers[n / 2];
        System.out.println(answer2);

        List<Integer> list = new ArrayList<>();
        int max = Collections.max(map.values());
        for(int key : map.keySet()) {
            if(map.get(key) == max) list.add(key);
        }
        
        if(list.size() == 1) {
            answer3 = list.get(0);
        } else {
            list.sort(null);
            answer3 = list.get(1);
        }
        System.out.println(answer3);

        answer4 = numbers[numbers.length - 1] - numbers[0];
        System.out.println(answer4);




    }
}