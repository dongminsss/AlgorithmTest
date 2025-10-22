class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        for(int i = 0; i<s.length(); i++) {
            answer = Math.max(answer , pallindrome(s, i, i));
            answer = Math.max(answer, pallindrome(s, i-1, i));
        }
        return answer;
    }
    private int pallindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) break;
            left--;
            right++;
        }
        return right - left - 1;
    }
}