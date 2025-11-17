import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            String name = br.readLine();
            map.put(name, name);
        }

        for(int i = 0; i<m; i++) {
            String name = br.readLine();
            if(map.containsKey(name)) {
                list.add(name);
            }
        }
        list.sort(null);
        System.out.println(list.size());
        list.stream().forEach(System.out::println);
    }
}
