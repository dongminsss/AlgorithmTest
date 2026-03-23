import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int s =  Integer.parseInt(br.readLine());
            if(s == 1) sb.append(1);
            if(s == 2) sb.append(2);
            if(s == 3) sb.append(4);
            if(s > 3) {
                int[] dp = new int[s];
                dp[0] = 1;
                dp[1] = 2;
                dp[2] = 4;
                for(int j = 3; j < dp.length; j++){
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
                }
                sb.append(dp[s-1]);
            }
            sb.append("\n");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }
}