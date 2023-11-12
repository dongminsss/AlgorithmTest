import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if(firstAbs == secondAbs) {
                return o1 > o2 ? 1:-1;
            } else {
                return firstAbs - secondAbs;
            }
        }));
        int length = Integer.parseInt(br.readLine());
        for(int i = 0; i<length; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) {
                if(priorityQueue.size() == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQueue.poll());
                }
            } else {
                priorityQueue.add(number);
            }
        }


    }
}