import java.util.*;
public class Main {
//charAt이용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] num2 = new String[num];
		String a = sc.next();
		num2 = a.split("");
		int[] arr = new int[num];
		int sum = 0;
		for (int i = 0; i < num; i++) {
			 arr[i] = Integer.parseInt(num2[i]);
			 sum += arr[i];
		}
		System.out.println(sum);
	}

}