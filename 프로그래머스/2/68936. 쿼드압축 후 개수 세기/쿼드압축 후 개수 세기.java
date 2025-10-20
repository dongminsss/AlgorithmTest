import java.util.*;

class Solution {
    private int[] answer;
    public int[] solution(int[][] arr) {
        
        answer = new int[2];
        divideConquer(0,0,arr, arr.length);
        
        return answer;
    }
    
    private void divideConquer(int x, int y, int[][] arr, int len) {
        if(valid(x, y, arr, len)) {
            answer[arr[y][x]]++;
            return;
        }
        int half = len / 2;
        divideConquer(x, y, arr, half);
        divideConquer(x , y + half, arr, half);
        divideConquer(x+half, y, arr, half);
        divideConquer(x+half, y+half, arr, half);
    }
    
    private boolean valid(int x, int y, int[][] arr, int len) {
        int number = arr[y][x];
        for(int i = y; i< y+len; i++) {
            for (int j = x; j<x+len; j++) {
                if(number != arr[i][j]) return false;
            }
        }
        return true;
    }
}