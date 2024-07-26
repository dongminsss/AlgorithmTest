import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n % 3;
        int k = n / 3;
        String status = "SK";
        if(k % 2 == 0) {
            status = "CY";
        } else {
            status = "SK";
        }
        if (m == 0) {
            System.out.println(status);
        } else if (m == 1) {
            if(status.equals("CY")) {
                System.out.println("SK");
            } else {
                System.out.println("CY");
            }
        } else {
            System.out.println(status);
        }
    }
}
