import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int aNum = minNumber(arrayA);
        int bNum = minNumber(arrayB);
        boolean a = isTrue(aNum , arrayB);
        boolean b = isTrue(bNum, arrayA);
        
        if(a && !b) {
            answer = aNum;
        } else if (!a && b) {
            answer = bNum;
        } else if (a && b) {
            answer = Math.max(aNum, bNum);
        }
        return answer;
    }
    
    private int minNumber(int[] arr) {
        int min = arr[0];
        while(min > 1) {
            boolean flag = false;
            for(int i = 0; i< arr.length; i++) {
                if(arr[i] % min != 0) {
                    flag = true;
                    break;
                }  
            }
            if(flag) {
                min--;
            } else {
                break;
            }
            
        }
        return min > 1 ? min : 0;
    }
    
    private boolean isTrue(int a, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(a > 1 &&arr[i] % a == 0) return false;
        }
        return true;
    }
}