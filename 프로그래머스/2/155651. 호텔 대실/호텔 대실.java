import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] bookTime = conversionMinute(book_time);
        Arrays.sort(bookTime, (o1 , o2) -> {
                   if(o1[0] == o2[0]) { return Integer.compare(o1[1],o2[1]); } else { return Integer.compare(o1[0],o2[0]);}});
        
        for(int[] book : bookTime) {
            book[1] += 10;
        }
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for(int i = 0; i<bookTime.length; i++) {
            if(!rooms.isEmpty() && rooms.peek() <= bookTime[i][0]) rooms.poll();
            rooms.offer(bookTime[i][1]);
        }
        
        
        return rooms.size();
    }
    
    private int[][] conversionMinute(String[][] book_time) {
        int[][] minutes = new int[book_time.length][2];
        
        for(int i = 0; i<minutes.length; i++) {
            String[] str = book_time[i];
            for(int j = 0; j<2; j++) {
                String[] temp = str[j].split(":");
                minutes[i][j] = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            }
        }
        return minutes;
    }
}