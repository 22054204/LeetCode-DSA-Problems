class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int x = 0;
        for(int i=s.length()-1;i>=0;i--){
            int mul = (int)Math.pow(26, x++);
            ans += (((int)s.charAt(i)) - 64) * mul;
        }
        return ans;
    }
}