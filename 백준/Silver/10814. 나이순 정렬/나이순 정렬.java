import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<member> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int old =  Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new member(old, name));
        }
        list.sort(Comparator.comparingInt(m -> m.old));
        list.stream().forEach(System.out::println);
    }

    static class member {
        int old;
        String name;
        public member(int old, String name) {
            this.old = old;
            this.name = name;
        }
        @Override
        public String toString() {
            return old + " " + name;
        }
    }
}