import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<len-2; i++){
            int sum = 0;
            for(int j = i+1; j<len-1; j++){
                for(int k = j+1; k<len; k++){
                    sum = nums[i] + nums[j] + nums[k];
                    if(sum % 2 != 0 && sum % 3 !=0) list.add(sum);
                }
            }
        }
        System.out.print(list);
        for(Integer integer : list) {
            int count = 0;
            for(int i = 1; i<=integer; i++){
                if(integer % i == 0) count++;
            }
            if(count==2) answer++;
        }
        return answer;
    }
}