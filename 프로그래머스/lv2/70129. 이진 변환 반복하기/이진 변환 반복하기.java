class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuffer sb = new StringBuffer(s);
        while(sb.length() > 1) {
            int oneCount = 0;
            answer[0]++;
            for(int i= 0; i<sb.length(); i++){
                if(sb.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    oneCount++;
                }
            }
            sb.setLength(0);
            sb.append(Integer.toBinaryString(oneCount));
        }
        return answer;
    }
}