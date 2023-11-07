import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] numbers = new int[count];
        for(int i = 0; i<numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        double sum = 0;
        for(int i = 0; i< numbers.length; i++) {
            sum += (double) numbers[i] / (double) numbers[numbers.length-1] * 100;
        }
        System.out.println(sum / numbers.length);
    }
}