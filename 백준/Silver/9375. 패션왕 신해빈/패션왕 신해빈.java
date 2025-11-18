import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++) {
            int sum = 1;
            Map<String, List<String>> map = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            for(int j = 0; j<m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                map.computeIfAbsent(category,k-> new ArrayList<>()).add(item);
            }
            // 계산식
//            System.out.println("map = " + map);
            for(String key : map.keySet()) {
                sum *= (map.get(key).size() + 1);
            }
            sum -= 1;
            System.out.println(sum);
        }
    }
}