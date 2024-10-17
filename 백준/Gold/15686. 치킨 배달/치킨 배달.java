
import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] city;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1) {
                    homes.add(new int[]{i, j});
                } else if (city[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        combi(new ArrayList<>(), 0);
        System.out.println(minDistance);

    }

    static void combi (List<int[]> selectedChickens, int idx) {
        if(selectedChickens.size() == m) {
            int distance = calChickenDistance(selectedChickens);
            minDistance = Math.min(minDistance, distance);
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            selectedChickens.add(chickens.get(i));
            combi(selectedChickens, i+1);
            selectedChickens.remove(selectedChickens.size() - 1);
        }
    }

    static int calChickenDistance(List<int[]> selectedChickens) {
        int totalDistance = 0;

        for (int[] home : homes) {
            int hX = home[0];
            int hY = home[1];
            int minDistance = Integer.MAX_VALUE;

            for( int[] chicken : selectedChickens) {
                int cX = chicken[0];
                int cY = chicken[1];
                int distance = Math.abs(hX - cX) + Math.abs(hY - cY);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }
        return totalDistance;
    }
}