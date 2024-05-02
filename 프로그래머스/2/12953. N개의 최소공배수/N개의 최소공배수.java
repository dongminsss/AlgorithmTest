class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        int count = 0;
        while(count != -1) {
            for(int i = 0; i< arr.length; i++ ) {
                if(answer % arr[i] != 0) {
                    count++;
                }
            }
            if(count == 0) break;
            answer++;
            count = 0;
        }
        return answer;
    }
}