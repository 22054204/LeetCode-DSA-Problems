class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        String s = String.valueOf(n);
        String t = "";
        long sum = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                t+=s.charAt(i);
            }
            sum+=s.charAt(i) - '0';
        }
        long number = Long.parseLong(t);
        return number*sum;
    }
}