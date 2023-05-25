import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[1];
        int[] day = new int[progresses.length];
        for(int i = 0; i<progresses.length; i++){
            while(progresses[i] < 100){
                day[i]+=1;
                progresses[i] += speeds[i];
            }
        }
        int maxIdx = 0;
        list.add(1);
        System.out.println(Arrays.toString(day));
        for(int i = 1; i<day.length; i++){
            if(day[maxIdx] >= day[i]) {
                list.set(list.size()-1 , list.get(list.size()-1)+1);
            } else {
                list.add(1);
                maxIdx=i;
            }
        }
        return list;
    }
}