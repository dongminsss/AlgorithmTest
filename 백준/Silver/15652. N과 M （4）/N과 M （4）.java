
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];

        for(int i = 0; i< N; i++){
            arr[i] = i + 1;
        }

        solve(new ArrayList<>(), 0);

    }

    private static void solve(List<Integer> list , int depth) {
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < list.size(); i++){
                sb.append(list.get(i)).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!list.isEmpty()) {
                if(list.get(list.size()-1) <= arr[i]){
                    list.add(arr[i]);
                    solve(list, depth+1);
                    list.remove(list.size()-1);
                }
            } else {
                list.add(arr[i]);
                solve(list, depth+1);
                list.remove(list.size()-1);
            }
        }

    }
}