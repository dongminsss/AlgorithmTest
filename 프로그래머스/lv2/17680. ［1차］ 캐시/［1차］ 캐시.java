import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i<cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        for(int i = 0; i<cities.length; i++){
            if(list.size()<cacheSize ) {
                if(!list.contains(cities[i])) {
                    answer+=5;
                    list.addFirst(cities[i]);
                } else {
                    answer++;
                    list.remove(list.indexOf(cities[i]));
                    list.addFirst(cities[i]);
                }
            } else {
                if(!list.contains(cities[i])) {
                    answer+=5;
                    list.addFirst(cities[i]);
                    list.removeLast();
                } else {
                    answer++;
                    list.remove(list.indexOf(cities[i]));
                    list.addFirst(cities[i]);
                }
            }
        }
        return answer;
    }
}