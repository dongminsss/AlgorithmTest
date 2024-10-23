
import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        visited = new boolean[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        dfs(new ArrayList<>(),0);

    }

    private static void dfs(List<Integer> list,int depth) {
        if(depth == N) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                dfs(list,depth + 1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}