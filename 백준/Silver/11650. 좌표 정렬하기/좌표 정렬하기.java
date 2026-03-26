import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<xy> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new xy(x,y));
        }
        list.sort((xy1, xy2) -> {
            if (xy1.x == xy2.x) {
                return xy1.y - xy2.y;
            } else {
                return xy1.x - xy2.x;
            }
        });
        list.stream().forEach(xy -> System.out.println(xy.toString()));
    }
    static class xy {
        int x;
        int y;
        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}