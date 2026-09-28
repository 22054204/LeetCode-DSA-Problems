class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int L = 0;
        int R = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L') L++;
            if(s.charAt(i)=='R') R++;
            if(L==R) count++;
        }
        return count;
    }
}