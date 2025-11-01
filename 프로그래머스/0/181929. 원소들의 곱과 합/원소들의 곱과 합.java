class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int compare = 1;
        for(int n : num_list) {
            compare *= n;
            answer += n;
        }
        if(compare < answer * answer ) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}