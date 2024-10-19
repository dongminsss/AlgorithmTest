
import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int length;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n];
        arr = new int[n];
        length = m;
        for(int i = 0; i< n; i++){
            arr[i] = i + 1;
        }

        solve(new ArrayList<>(),  0, bw);
        bw.flush();
        bw.close();
        
    }

    private static void solve(List<Integer> list, int depth, BufferedWriter bw) throws IOException {
        if(depth == length){
            StringBuffer sb = new StringBuffer();
            for(Integer i: list) {
                sb.append(i).append(" ");
            }
            bw.write(sb.toString().trim() + "\n");
            return;
        }


        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            solve(list,  depth+1, bw);
            list.remove(list.size()-1);
        }


    }
}