import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int idx = commands[i][2]-1;
            for(int j = start; j<=end; j++) {
                list.add(array[j]);
            }
            list.sort(null);
            answer[i] = list.get(idx);
        }
        return answer;
    }
}