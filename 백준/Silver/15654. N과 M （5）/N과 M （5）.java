import javax.sound.sampled.EnumControl;
import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;

public class Main {
    static int[] array;
    static int M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i< n; i++) {
            visited[i] = true;
            list.add(array[i]);
            dfs(1, list);
            list.remove(list.size()-1);
            visited[i] = false;
        }


    }

    private static void dfs(int depth, List<Integer> list) {
        if(depth == M) {

            for(int number : list) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < array.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(array[i]);
                dfs(depth+1, list);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }



    }
}
