
import java.util.*;
import java.io.*;

public class Main {
    static int[] numbers;
    static List<Integer> sum = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        int count = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
//        for(int i = 1; i <= n; i++) {
//            combi(0, i, new ArrayList<>());
//        }
//
//        for(int i = 0; i < sum.size(); i++) {
//            boolean bol = true;
//            for(int j = 0; j < sum.size(); j++) {
//                if(sum.get(j) == count) bol = false;
//            }
//            if(bol) break;
//            count++;
//        }
//        System.out.println(count);

        Arrays.sort(numbers);

        int res = 1;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > res) {
                break;
            } else {
                res += numbers[i];
            }
        }

        System.out.println(res);


    }

    private static void combi(int start, int r, List<Integer> current) {
        if(current.size() == r) {
            int count = 0;
            for(int i = 0; i < current.size(); i++) {
                count += current.get(i);
            }
            sum.add(count);
            return;
        }
        for (int i = start; i< numbers.length; i++) {
            current.add(numbers[i]);
            combi(i+1, r, current);
            current.remove(current.size()-1);
        }
    }
}