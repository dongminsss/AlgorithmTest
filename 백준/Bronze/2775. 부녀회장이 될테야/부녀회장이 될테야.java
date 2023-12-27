import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i <testCase; i++) {
            int result = 0;
            int floor = Integer.parseInt(br.readLine());
            int ho = Integer.parseInt(br.readLine());
            int[] people = new int[ho];
            int[] prevPeople = new int[ho];
            for (int j = 0; j <floor ; j++) {
                for (int k = 0; k <ho ; k++) {
                    if(j==0) {
                        people[k] = k+1;
                    } else if(k == 0) {
                        people[k] = 1;
                    } else {
                        int sum = 0;
                        for (int l = 0; l <=k ; l++) {
                            sum += prevPeople[l];
                        }
                        people[k] = sum;
                    }
                }
                int count = 0;
                for(int number : people) {
                    prevPeople[count++] = number;
                }
            }
            for(int j : people) {
                result += j;
            }
            System.out.println(result);
        }
    }
}
