import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        for(int[] size : sizes) {
            if(size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }
        Arrays.sort(sizes, (o1,o2) -> Integer.compare(o2[0],o1[0]));
        int maxH = sizes[0][0];
        Arrays.sort(sizes, (o1,o2) -> Integer.compare(o2[1],o1[1]));
        int maxW = sizes[0][1];
        int answer = maxH * maxW;
        return answer;
    }
}