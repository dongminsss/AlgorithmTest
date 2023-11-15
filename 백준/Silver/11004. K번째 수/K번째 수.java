import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int searchIndex = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sort(arr, 0, length-1, searchIndex-1);
        System.out.println(arr[searchIndex-1]);
    }

    static void sort(int[] arr, int start, int end, int k) {
        int pivot = partitionIndex(arr,start, end);
        if(pivot == k) return;
        if(k < pivot) {
            sort(arr, start, pivot -1, k);
        } else {
            sort(arr, pivot+1 , end, k);
        }
    }

    static int partitionIndex(int[] arr,int start, int end) {
        if(start + 1 == end) {
            if(arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }
        int middle = (start + end) / 2;
        swap(arr, start , middle);
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <arr.length && pivot > arr[i]) i++;
            while (j > 0 && pivot < arr[j]) j--;
            if(i<=j) swap(arr, i++, j--);
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

