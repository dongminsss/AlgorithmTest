import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int countHansu = 99;
        if(n < 100) {
            countHansu = n;
        } else {
            for(int i = 100; i <= n; i++) {
                if(hansu(i)) {
                    countHansu++;
                }
            }
        }
        System.out.println(countHansu);
    }

    private static boolean hansu(int number) {
        int beakNumber = number / 100;
        int sipNumber = (number % 100) / 10;
        int ilNumber = number % 10;

        return beakNumber - sipNumber == sipNumber - ilNumber;
    }
}
