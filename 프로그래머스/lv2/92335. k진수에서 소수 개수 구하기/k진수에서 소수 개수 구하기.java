//import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kNumber = "";
        while( n >0) {
            kNumber = n % k + kNumber;
            n = n/k;
        }
        String[] arr = kNumber.split("0");
        //System.out.print(Arrays.toString(arr));
        String str = "";
        for(int i = 0; i<arr.length; i++){
            if(arr[i].equals("1") || arr[i].equals("")) {
                continue;
            } else {
                if(isPrime(Long.parseLong(arr[i]))) answer++;
            }
            
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return false; 
        }
        return true;
    }
}