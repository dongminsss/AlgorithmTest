import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] ongals = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for(String s : babbling) {
            for(int i = 0; i<4; i++) {
                s = s.replaceAll(ongals[i], " ");
            }
            if(s.trim().isEmpty()) answer++;
        }
        return answer;
    }
}