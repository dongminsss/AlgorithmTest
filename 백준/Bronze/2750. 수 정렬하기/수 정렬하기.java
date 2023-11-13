import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] numbers = new int[count];
        for(int i = 0; i<count; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i<count; i++){
            for(int j = 0; j<count-1; j++){
                if(numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        for(int i : numbers) {
            System.out.println(i);
        }

    }
}