import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> hours = new TreeMap<>();
        Map<String, String> hourTable = new HashMap<>();
        Map<String, String> statusTable = new HashMap<>();
        
        for(int i = 0; i<records.length; i++) {
            String[] strArr = records[i].split(" ");
            String hour = strArr[0];
            String car = strArr[1];
            String status = strArr[2];
            
            if(status.equals("IN")) {
                hourTable.put(car, hour);
                statusTable.put(car, status);
            } else {
                int nowHour = Integer.parseInt(hour.split(":")[0]) * 60;
                nowHour += Integer.parseInt(hour.split(":")[1]);
                int prevHour = Integer.parseInt(hourTable.get(car).split(":")[0]) * 60;
                prevHour += Integer.parseInt(hourTable.get(car).split(":")[1]);
                hours.put(car, hours.getOrDefault(car,0) + (nowHour - prevHour));
                statusTable.put(car, status);
                
            }
        }
        for(String car : statusTable.keySet()) {
            if(statusTable.get(car).equals("IN")) {
                int prevHour = Integer.parseInt(hourTable.get(car).split(":")[0]) * 60 + Integer.parseInt(hourTable.get(car).split(":")[1]);
                int lastHour = (23*60) + 59;
                
                hours.put(car, hours.getOrDefault(car, 0) + (lastHour - prevHour));
            }
        }
        
        for(String car : hours.keySet()) {
            int hour = hours.get(car);
            int count = fees[1];
            int sum = (int) Math.ceil((double)(hour - fees[0]) / fees[2]) * fees[3];
            if(sum > 0) count += sum;
            answer.add(count);
        }

        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}