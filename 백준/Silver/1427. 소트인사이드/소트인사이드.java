import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberStr = br.readLine();
        int[] numbers = new int[numberStr.length()];
        for(int i = 0; i<numberStr.length(); i++) {
            numbers[i] = Integer.parseInt(numberStr.substring(i, i+1));
        }
        for(int i = 0; i<numbers.length; i++) {
            int max = numbers[i];
            int maxIndex = i;
            for(int j = i+1; j<numbers.length; j++) {
                if (max < numbers[j]) {
                    max = numbers[j];
                    maxIndex = j;
                }
            }
            numbers[maxIndex] = numbers[i];
            numbers[i] = max;
        }
        StringBuffer sb = new StringBuffer();
        for(int i : numbers) sb.append(i);
        System.out.println(sb);
    }
}
