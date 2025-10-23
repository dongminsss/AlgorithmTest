import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int[] target = getIdx(ext, sort_by);
        for(int[] arr : data) {
            if(arr[target[0]] < val_ext) list.add(arr);
        }
        list.sort((o1,o2) -> o1[target[1]] - o2[target[1]]);
        
        return list.toArray(new int[0][]);
    }
    
    private int[] getIdx(String ext, String sort_by) {
        int[] result = new int[2];
        switch(ext) {
            case "date" -> result[0] = 1;
            case "maximum" -> result[0] = 2;
            case "remain" -> result[0] = 3;
        }
        switch(sort_by) {
            case "date" -> result[1] = 1;
            case "maximum" -> result[1] = 2;
            case "remain" -> result[1] = 3;
        }
        return result;
    } 
}