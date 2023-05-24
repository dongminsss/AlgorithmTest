class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zero = 0;
        for(int i = 0; i<lottos.length; i++){
            if(lottos[i] == 0) zero++;
            for(int j = 0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]) count++;
            }
        }
        if(count ==0 && zero == 0) {
            answer[0] = 6;
            answer[1] = 6;
        } else if(count==0) {
            answer[0] = 7-(count+zero);
            answer[1] = 6;
        } else {
            answer[0] = 7-(count+zero);
            answer[1] = 7-count;
        }
        
        return answer;
    }
}