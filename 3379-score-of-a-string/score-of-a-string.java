class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        int i=0;
        int j=1;
        while(j<s.length()){
            int sub = Math.abs((int)(s.charAt(i))-(int)(s.charAt(j)));
            sum += sub;
            i++;
            j++;
        }
        return sum;
    }
}