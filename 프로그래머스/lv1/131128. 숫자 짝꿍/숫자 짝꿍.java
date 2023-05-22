import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuffer answer = new StringBuffer();
        int[] countX = new int[10];
        int[] countY = new int[10];
        Solution.count(X, countX);
        Solution.count(Y, countY);
        for(int i = 9; i>=0; i--){
            while(countX[i] > 0 && countY[i] > 0) {
                if(i==0 && answer.length() == 0){
                    answer.append("0");
                    break;
                }
                answer.append(Integer.toString(i));
                countX[i]--;
                countY[i]--;
            }
        }
        if(answer.length()==0) answer.append("-1");
        return answer.toString();
    }
    
    public static void count(String X, int[] arr) {
        for(int i = 0; i<X.length(); i++) {
            switch(X.charAt(i)){
                case '0': arr[0]++;
                        break;
                case '1': arr[1]++;
                        break;
                case '2': arr[2]++;
                        break;
                case '3': arr[3]++;
                        break;
                case '4': arr[4]++;
                        break;
                case '5': arr[5]++;
                        break;
                case '6': arr[6]++;
                        break;
                case '7': arr[7]++;
                        break;
                case '8': arr[8]++;
                        break;
                case '9': arr[9]++;
                        break;
            }
        }
    }
}