import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        int len = p.length();
        for(int i = 0; i<=t.length()-len; i++){
            list.add(t.substring(i,len+i));
        }
        long Pnum = Long.parseLong(p);
        for(String number : list) {
            long getNum = Long.parseLong(number);
            if(getNum <= Pnum) answer++;
        }
        return answer;
    }
}