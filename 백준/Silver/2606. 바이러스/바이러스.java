import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int arrayLength = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        visited = new boolean[length+1];
        for(int i = 0; i<=length; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i = 0; i<arrayLength; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            arr.get(index).add(number);
            arr.get(number).add(index);
        }
        dfs(1);
        int count = -1;
        for(boolean i: visited) {
            if(i) count++;
        }
        System.out.println(count);
    }
    public static void dfs(int number){
        visited[number] = true;
        for(int i : arr.get(number)) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}
