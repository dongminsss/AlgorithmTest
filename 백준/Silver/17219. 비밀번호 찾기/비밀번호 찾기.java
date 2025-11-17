import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> table = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            table.put(st.nextToken(), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++) {
            sb.append(table.get(br.readLine()) + "\n");
        }
        System.out.println(sb);
    }
}