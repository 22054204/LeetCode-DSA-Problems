class Solution {
    public int titleToNumber(String s) {
        return Method2(s);
    }
    // instead of using pow() method ... me build an precompute an array with pow of 26 from minLenght == 1 to maxLength of String == 7, to got pow of 26 in O(1) complexity.
    public int Method2(String s) {
        int ans = 0;
        int[] pow26 = {1,26,676,17576,456976,11881376,308915776}; //1 <= columnTitle.length <= 7
        int x = 0;
        for(int i=s.length()-1;i>=0;i--){
            int mul = pow26[x++];
            ans += (((int)s.charAt(i)) - 64) * mul;
        }
        return ans;
    }
    // using inbuild pow() Method
    public int Method1(String s) {
        int ans = 0;
        int x = 0;
        for(int i=s.length()-1;i>=0;i--){
            int mul = (int)Math.pow(26, x++);
            ans += (((int)s.charAt(i)) - 64) * mul;
        }
        return ans;
    }
}