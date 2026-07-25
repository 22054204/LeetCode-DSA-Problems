class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int[] pow26 = {1,26,676,17576,456976,11881376,308915776}; //1 <= columnTitle.length <= 7
        int x = 0;
        for(int i=s.length()-1;i>=0;i--){
            int mul = pow26[x++];
            ans += (((int)s.charAt(i)) - 64) * mul;
        }
        return ans;
    }
}