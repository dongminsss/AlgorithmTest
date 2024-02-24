import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> numSet = new HashSet<>();
        permutation("", numbers, numSet);
        for(Integer number : numSet) {
            if(isPrime(number)) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public static void permutation(String prefix, String str, Set<Integer> set) {
         int n = str.length();
        if (!prefix.equals("")) set.add(Integer.parseInt(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
    }
    public static boolean isPrime(int number) {
        if(number == 0) return false;
        if(number == 1) return false;
        for(int i = 2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) return false; 
        }
        return true;
    }
}