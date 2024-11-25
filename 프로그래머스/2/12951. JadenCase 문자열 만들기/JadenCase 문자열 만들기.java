class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String fix = s.toLowerCase();
        for(int i = 0; i<s.length(); i++){
            String c = String.valueOf(fix.charAt(i));
            if(i == 0) {
                c = c.toUpperCase();
            } else if(fix.charAt(i-1) == ' ') {
                c = c.toUpperCase();
            } 
            sb.append(c);
        }
        String answer = sb.toString();
        return answer;
    }
}