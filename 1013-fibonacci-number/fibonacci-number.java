class Solution {
    public int fib(int n) {
        if(n<2) return n;
        int prev2 = 0;
        int prev1 = 1;
        int curri = 0;
        for(int i=2;i<=n;i++){
            curri = prev1+prev2;
            prev2 = prev1;
            prev1 = curri;
        }
        return curri;
    }
}