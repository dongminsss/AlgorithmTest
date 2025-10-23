import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int height = n / w;
        if(n % w > 0) height += 1;
        int[][] boxs = new int[height][w];
        int[] target = new int[2];
        int floor = 1;
        int x = 0;
        int y = height-1;
        int number = 1;
        int answer = 0;
        while(y >= 0){
            if(floor % 2 == 0) {
                for(int i = w - 1; i >= 0; i--) {
                    if(number == num) target = new int[]{y,i};
                    if(number > n) break;
                    boxs[y][i] = number++;
                }
            } else {
                for(int i = 0; i<w; i++) {
                    if(number == num) target = new int[]{y,i};
                    if(number > n) break;
                    boxs[y][i] = number++;
                }
            }
            y--;
            floor++;
        }
        // System.out.println(Arrays.deepToString(boxs));
        for(int i = target[0]; i >= 0; i--) {
            if(boxs[i][target[1]] != 0) answer++;  
        }
        
        return answer;
    }
}