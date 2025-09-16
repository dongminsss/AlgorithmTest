import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (s1, s2) ->{
            String[] part1 = separate(s1);
            String[] part2 = separate(s2);
            
            int headCompare = part1[0].compareTo(part2[0]);
            
            if(headCompare !=0) {
                return headCompare;
            }
            
            int num1 = Integer.parseInt(part1[1]);
            int num2 = Integer.parseInt(part2[1]);
            
            return num1 - num2;
        });
        
        return files;
    }
    
    private String[] separate(String s) {
        String head = "";
        String number = "";
        String tail = "";
        
        int i = 0;
        while (i < s.length() && !Character.isDigit(s.charAt(i))) {
            i++;
        }
        head = s.substring(0, i).toLowerCase();
        
        int j = i;
        while(j<s.length() && Character.isDigit(s.charAt(j))) {
            j++;
        }
        number = s.substring(i, j);
        
        return new String[] {head, number};
        
    }
}