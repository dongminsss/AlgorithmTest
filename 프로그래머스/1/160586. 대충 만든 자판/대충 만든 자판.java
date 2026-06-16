class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];
        
        for(int i = 0; i<targets.length; i++) {
            int total = 0;
            for(char c : targets[i].toCharArray()) {
                int min = 101;
                for(int j = 0; j<keymap.length; j++) {
                    for(int k = 0; k < keymap[j].length(); k++) {
                        if(keymap[j].charAt(k) == c) min = Math.min(min, k +1 );
                    }
                }
                if(min == 101) answer[i] = -1;
                total += min;
            }
            if(answer[i] == -1) continue;
            answer[i] = total;
        }
        return answer;
    }
}