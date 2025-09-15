import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    private static class Song {
        int id;
        String genre;
        int play;
        
        public Song(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> board = new HashMap<>();
        int len = genres.length;
        for(int i = 0; i<len; i++) {
            board.put(genres[i], board.getOrDefault(genres[i],0) + plays[i]);
        }
        List<String> sortedGenres = board.keySet().stream()
                .sorted((g1, g2) -> board.get(g2).compareTo(board.get(g1)))
                .collect(Collectors.toList());
        
        Map<String, List<Song>> songBoard = new HashMap<>();
        for(int i = 0; i<len; i++) {
          songBoard.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, genres[i], plays[i]));

        }
      songBoard.values().forEach(songs -> {
            songs.sort((s1, s2) -> {
                if (s1.play == s2.play) {
                    return s1.id - s2.id;
                }
                return s2.play - s1.play;
            });
        });

        List<Integer> bestAlbum = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = songBoard.get(genre);
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                bestAlbum.add(songs.get(i).id);
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
}