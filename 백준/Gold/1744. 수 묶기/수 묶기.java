import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> positiveNumber = new ArrayList<>();
        List<Integer> negativeNumber = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i<length; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number ==  0) {
                zero.add(number);
            } else if (number == 1) {
                one.add(number);
            } else if (number > 1) {
                positiveNumber.add(number);
            } else {
                negativeNumber.add(number);
            }
        }
        positiveNumber.sort(null);
        negativeNumber.sort(null);
        while (positiveNumber.size() > 1) {
            int a = positiveNumber.remove(positiveNumber.size() -1);
            int b = positiveNumber.remove(positiveNumber.size() -1);
            sum += a*b;
        }
        while (negativeNumber.size() > 1) {
            int a = negativeNumber.remove(0);
            int b = negativeNumber.remove(0);
            sum+= a * b;
        }
        while (!one.isEmpty()) {
            sum += one.remove(0);
        }
        if(!positiveNumber.isEmpty()) sum += positiveNumber.remove(0);
        if(zero.isEmpty()) {
            if(!negativeNumber.isEmpty()) sum += negativeNumber.remove(0);
        }
        System.out.println(sum);
    }
}