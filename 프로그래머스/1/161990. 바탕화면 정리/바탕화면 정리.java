import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        // int[] answer = new int[4];
        int minX = 51;
        int minY = 51;
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i<wallpaper.length; i++) {
            char[] arr = wallpaper[i].toCharArray();
            for(int j = 0; j<arr.length; j++) {
                if(arr[j] == '#') {
                    minY = Math.min(minY, i);
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j+1);
                    maxY = Math.max(maxY, i+1);
                }
            }
        }
        return new int[]{minY, minX, maxY, maxX};
    }
}