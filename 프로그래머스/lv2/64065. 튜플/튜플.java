import java.util.*;
class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ranking = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        s = s.replace("{{","");
        s = s.replace("}}","");
        s = s.replace("},{",",");
        s += ",";
        String number = "";
        for(int i = 0; i<s.length(); i++){
            if(s.contains(",")) {
                if(s.charAt(i) == ',') {
                    map.put(number, map.getOrDefault(number,0) + 1);
                    number = "";
                } else {
                    number += Character.toString(s.charAt(i));
                }
            } 
        }
        int[] answer = new int[map.size()];
        for(String key : map.keySet()) {
            ranking.add(map.get(key));
            list.add(Integer.parseInt(key));
        }
        int j = 0;
        for(int i = list.size()-1; i>=0; i--){
            answer[j++] = list.get(ranking.indexOf(i+1));
        }
        
        return answer;
    }
}