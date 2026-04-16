class Solution {
    public int solution(int n, long l, long r) {
        
        return (int)(count(n, r) - count(n,l-1));
    }
    
    long count(int n, long k) {
        if(k <= 0) return 0;
        if(n == 0) return 1;
        
        long size = (long)Math.pow(5, n-1);
        long loc = (k - 1) / size;
        long rem = k - loc * size;
        
        
        long prev = (long)Math.pow(4,n-1);
        if(loc == 2) return 2 * prev;
        long block = (loc >= 3) ? loc - 1 : loc;
        return block * prev + count(n-1, rem);
    }
}