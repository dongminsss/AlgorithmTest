import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        for(String str : cities){
            String city = str.toLowerCase();
            
            if(list.contains(city)) {
                list.remove(city);
                list.add(city);
                answer += 1;
            } else {
                if(list.size() == cacheSize) {
                    list.remove(0);
                }
                list.add(city);
                answer+=5;
            }
        }
        return answer;
    }
}