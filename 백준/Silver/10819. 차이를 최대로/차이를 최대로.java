
import java.util.*;
import java.io.*;

public class Main {
    static int maxValue = Integer.MIN_VALUE;
    static int length;
    static boolean[] visited;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        length = n;
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        solve(new ArrayList<>());
        System.out.println(maxValue);
    }

    static void solve(List<Integer> current) {
        if(current.size() == length) {
            maxValue = Math.max(maxValue, cal(current));
            return;
        }

        for(int i = 0; i<length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current.add(numbers[i]);
                solve(current);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }
    static int cal(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size()-1; i++) {
            sum += Math.abs(list.get(i)-list.get(i+1));
        }
        return sum;
    }

}