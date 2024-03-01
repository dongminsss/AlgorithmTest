class Solution {
    public int solution(String s) {
        int answer = 0;
        int xCount =1;
        int noneXCount = 0;
        char ch = s.charAt(0);
        if(s.length() == 1) answer++;
        for(int i = 1; i<s.length(); i++) {
            if(ch == s.charAt(i)) {
                xCount++;
            } else {
                noneXCount++;
            }
            if(xCount == noneXCount){
                answer++;
                xCount = 0;
                noneXCount = 0;
                System.out.println(ch);
                if(i + 1 == s.length()) break;
                ch = s.charAt(i+1);
            } 
            if(i == s.length()-1) answer++;
        }
        return answer;
    }
}