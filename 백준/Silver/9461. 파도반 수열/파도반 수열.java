import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(padobanNumber(Integer.parseInt(br.readLine())))
                    .append("\n");
        }
        System.out.print(sb);
    }
    public static long padobanNumber(int n) {
        if(n == 1 || n == 2 || n == 3){
            return 1;
        }
        long[] memory = new long[n+1];
        memory[1] = 1;
        memory[2] = 1;
        memory[3] = 1;
        for(int i = 4; i <=n; i++) {
            memory[i] = memory[i-2] + memory[i-3];
        }
        return memory[n];
    }
}