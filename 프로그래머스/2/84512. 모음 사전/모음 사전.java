import java.util.*;
class Solution {
    static String[] arr;
    static ArrayList<String> list;
    public int solution(String word) {
        list = new ArrayList<>();
        arr = new String[]{"A","E","I","O","U"};
        int answer = 0;
        burt("", 0);
        for(int i = 0; i<list.size(); i++) {
            if(word.equals(list.get(i))) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    static void burt(String str, int depth) {
        list.add(str);
        if(depth == 5) return;
        for(int i = 0; i<arr.length; i++) {
            burt(str+arr[i], depth+1);
        }
    }
}