import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] sum = new long[n+1];
        for(int i = 0; i<n; i++) {
            int plus = sc.nextInt();
            sum[i+1] += sum[i] + plus;
        }
        for(int i = 0; i<m; i++) {
            int firstIndex = sc.nextInt();
            int lastIndex = sc.nextInt();
            System.out.println(sum[lastIndex]-sum[firstIndex-1]);
        }

    }
}