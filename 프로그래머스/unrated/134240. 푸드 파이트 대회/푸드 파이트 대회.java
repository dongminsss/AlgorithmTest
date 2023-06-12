class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<food.length; i++){
            for(int j = 0; j<food[i]/2; j++){
                sb.append(Integer.toString(i));
            }
        }
        String reverse = new StringBuilder(sb).reverse().toString();
        answer = sb.toString();
        answer = answer + "0" + reverse;
        return answer;
    }
}