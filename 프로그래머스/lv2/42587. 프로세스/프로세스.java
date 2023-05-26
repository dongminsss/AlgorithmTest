import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> queName = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i= 0; i<priorities.length; i++) {
            queName.add(i+1);
            list.add(priorities[i]);
        }
        Arrays.sort(priorities);
        int maxIdx = priorities.length-1;
        int maxValue = priorities[maxIdx];
        while(maxValue > 0) {
            if(list.get(0) <maxValue) {
                list.add(list.get(0));
                queName.add(queName.get(0));
                queName.remove(0);
                list.remove(0);
            } else {
                if(queName.get(0) == location+1) {
                    answer++;
                    break;
                } else {
                    list.remove(0);
                    queName.remove(0);
                    maxValue=priorities[--maxIdx];
                    answer++;
                }
            }
           
        }
        return answer;
    }
}