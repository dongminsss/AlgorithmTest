class Solution {
    public int solution(String s) {
        int max = s.length();
        int answer = max; 
        int half = max / 2;

        for (int len = 1; len <= half; len++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, len);
            int count = 1;

            for (int i = len; i < max; i += len) {
                int end = Math.min(i + len, max);
                String curr = s.substring(i, end);

                if (curr.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = curr;
                    count = 1;
                }
            }

            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
