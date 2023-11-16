import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        for(int i = 0; i<length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        merge(arr);
        for(int i : arr) {
            bw.write(i +"\n");
        }
        bw.flush();
        bw.close();
    }
    static void merge(int[] arr){
        int[] temp = new int[arr.length];
        partitionMerge(arr, temp, 0 , arr.length-1);
    }
    static void partitionMerge(int[] arr, int[] temp, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            partitionMerge(arr, temp, start, mid);
            partitionMerge(arr, temp, mid+1 , end);
            merge(arr, temp, start , mid , end);
        }
    }
    static void merge (int[] arr, int[] temp, int start, int mid, int end) {
        for(int i = start; i<= end; i++) {
            temp[i] = arr[i];
        }
        int partOne = start;
        int partTwo = mid + 1;
        int index = start;
        while (partOne <= mid && partTwo <= end) {
            if(temp[partOne] <= temp[partTwo]) {
                arr[index] = temp[partOne];
                partOne++;
            } else {
                arr[index] = temp[partTwo];
                partTwo++;
            }
            index++;
        }
        for(int i = 0; i<=mid - partOne; i++) {
            arr[index + i] = temp[partOne + i];
        }
    }
}
