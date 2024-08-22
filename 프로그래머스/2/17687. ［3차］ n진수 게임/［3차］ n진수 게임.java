import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder("0");
        int length = t * m;
        String[] arr = {"A", "B", "C", "D", "E", "F"};
        for(int i = 1; i<length; i++) {
            StringBuilder sb2 = new StringBuilder();
            int j = i;
            while(j > 0) {
                if(j % n == 0) {
                    sb2.append("0");
                } else {
                    int number = j % n;
                    if(number >= 10) {
                        sb2.append(arr[number % 10]);
                    } else {
                        sb2.append(number);    
                    }
                    
                }
                j = j / n;
            }
            sb.append(sb2.reverse().toString());
        }
        int count = 0;
        String answer = "";
        for(int i = p-1; i < length; i += m) {
            answer = answer + sb.charAt(i);
        }
        
        return answer;
    }
}