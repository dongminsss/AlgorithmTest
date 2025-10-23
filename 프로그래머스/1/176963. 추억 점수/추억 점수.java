import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] answer = new int[photo.length];
        for(int i = 0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        int idx = 0;
        for(String[] strArr : photo) {
            int count = 0;
            for(String str : strArr) {
                if(map.get(str) != null) {
                    count += map.get(str);
                }
            }
            answer[idx++] = count;
        }
        
        
        return answer;
    }
}