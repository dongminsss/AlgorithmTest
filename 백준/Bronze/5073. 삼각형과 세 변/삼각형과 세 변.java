import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int oneLine = Integer.parseInt(st.nextToken());
            int twoLine = Integer.parseInt(st.nextToken());
            int threeLine = Integer.parseInt(st.nextToken());
            boolean triangle = true;
            int max = 0;
            if(oneLine == 0 && twoLine == 0 && threeLine == 0) {
                break;
            }
            if(max < oneLine) {
                max = oneLine;
                if(max >= twoLine + threeLine) triangle = false;
            } else {
                triangle = true;
            }
            if(max < twoLine) {
                max = twoLine;
                if(max >= oneLine + threeLine) triangle = false;
            } else {
                triangle = true;
            }
            if(max < threeLine) {
                max = threeLine;
                if(max >= twoLine + oneLine) triangle = false;
            } else {
                triangle = true;
            }
            if(!triangle) System.out.println("Invalid");
            if(oneLine == threeLine && twoLine == threeLine && triangle) {
                System.out.println("Equilateral");
            } else if((twoLine == oneLine || twoLine == threeLine || oneLine == threeLine) && triangle ) {
                System.out.println("Isosceles");
            } else if(triangle) {
                System.out.println("Scalene");
            }

        }
    }
}