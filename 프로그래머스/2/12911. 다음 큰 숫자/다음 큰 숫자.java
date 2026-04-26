class Solution {
    public int solution(int n) {
        int answer = n+1;
        while(true) {
            if(matchOne(Integer.toBinaryString(n), Integer.toBinaryString(answer))) break;
            answer++;
        }
        return answer;
    }
    
    boolean matchOne(String a, String b) {
        int countA = 0;
        int countB = 0;
        for(char c : a.toCharArray()) {
            if(c == '1') countA++;
        }
        for(char c : b.toCharArray()) {
            if(c == '1') countB++;
        }
        if(countA == countB) return true;
        return false;
    }
    
}