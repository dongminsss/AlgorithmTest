import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split("-");
        int result = 0;
        for(int i = 0; i<strArr.length; i++) {
            if(i == 0)  {
                result += minusSum(strArr[i]);

            } else {
                result -= minusSum(strArr[i]);
            }
        }
        System.out.println(result);
    }
    public static int minusSum(String str){
        String[] strArr = str.split("\\+");
        int sum = 0;
        for(int i = 0; i<strArr.length; i++) {
            sum += Integer.parseInt(strArr[i]);
        }
        return sum;
    }
}
