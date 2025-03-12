import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static class Matrix implements Comparable<Matrix> {
        int x;
        int y;

        Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Matrix o) {
            if(this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Matrix[] matrixs = new Matrix[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            matrixs[i] = new Matrix(x, y);
        }
        Arrays.sort(matrixs);
        for(Matrix m : matrixs) {
            System.out.println(m.x + " " + m.y);
        }


    }

}