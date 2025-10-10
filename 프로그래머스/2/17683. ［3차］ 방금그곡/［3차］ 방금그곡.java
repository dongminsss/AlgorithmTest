import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "";
        String[][] conversionMusics = conversion(musicinfos);
        String conversionMelody = sharpToLowerCase(m);
        List<String[]> list = new ArrayList<>();
        
        for(int i = 0; i<conversionMusics.length; i++) {
            String str = conversionMusics[i][2];
            if(str.contains(conversionMelody)) list.add(conversionMusics[i]);
        }
        if(list.isEmpty()) return "(None)";
        list.sort((o1,o2) -> {
            int number1 = Integer.parseInt(o1[0]);
            int number2 = Integer.parseInt(o2[0]);
            int idx1 = Integer.parseInt(o1[3]);
            int idx2 = Integer.parseInt(o2[3]);
            if(number1 != number2) {
                return number2 - number1;
            } else {
                return idx1 - idx2;
            }
        });
        
        answer = list.get(0)[1];
        return answer;
    }
    
    private String[][] conversion (String[] musics) {
        String[][] result = new String[musics.length][4];
        
        for(int i = 0; i<musics.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] strs = musics[i].split(",");
            int start = Integer.parseInt(strs[0].split(":")[0]) * 60 + Integer.parseInt(strs[0].split(":")[1]);
            int end = Integer.parseInt(strs[1].split(":")[0]) * 60 + Integer.parseInt(strs[1].split(":")[1]);
            int during = end - start;
            result[i][0] = Integer.toString(during);
            result[i][1] = strs[2];
            
            String melody = sharpToLowerCase(strs[3]); 
            StringBuilder playedMelody = new StringBuilder();
            for (int j = 0; j < during; j++) {
                playedMelody.append(melody.charAt(j % melody.length()));
            }
            result[i][2] = playedMelody.toString();
            result[i][3] = Integer.toString(i);
        }
        return result;
    }
    
    private String sharpToLowerCase(String s) {
    return s.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a")
            .replaceAll("B#", "b")
            .replaceAll("E#", "e");
    }
}