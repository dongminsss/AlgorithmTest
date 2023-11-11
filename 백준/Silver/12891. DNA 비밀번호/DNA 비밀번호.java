import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer countSt = new StringTokenizer(br.readLine());
        int dnaLength = Integer.parseInt(countSt.nextToken());
        int partLength = Integer.parseInt(countSt.nextToken());
        String dna = br.readLine();
        countSt = new StringTokenizer(br.readLine());
        int aCount = Integer.parseInt(countSt.nextToken());
        int cCount = Integer.parseInt(countSt.nextToken());
        int gCount = Integer.parseInt(countSt.nextToken());
        int tCount = Integer.parseInt(countSt.nextToken());
        int matchCount = 0;
        int[] addCountArr = new int[4];
        for(int i = 0; i<dnaLength; i++) {
            add(dna.charAt(i), addCountArr);
            if(i == partLength -1) {
                matchCount += match(addCountArr, aCount, cCount, gCount, tCount);

            } else if(i > partLength -1) {
                remove(dna.charAt(i - partLength), addCountArr);
                matchCount += match(addCountArr, aCount, cCount, gCount, tCount);
            }
        }
        System.out.println(matchCount);
    }
    public static int match(int[] arr, int a, int c, int g, int t) {
        if(arr[0] >= a && arr[1] >= c && arr[2] >= g && arr[3] >= t ) return 1;
        return 0;
    }

    public static void add(char a, int[] arr) {
        switch (a) {
            case 'A':
                arr[0]++;
                break;
            case 'C':
                arr[1]++;
                break;
            case 'G':
                arr[2]++;
                break;
            case 'T':
                arr[3]++;
                break;
        }
    }
    public  static void remove(char a, int[] arr) {
        switch (a) {
            case 'A':
                arr[0]--;
                break;
            case 'C':
                arr[1]--;
                break;
            case 'G':
                arr[2]--;
                break;
            case 'T':
                arr[3]--;
                break;
        }
    }
}