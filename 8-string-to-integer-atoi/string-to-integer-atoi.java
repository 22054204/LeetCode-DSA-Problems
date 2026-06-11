class Solution {
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        s = s.trim();
        if(s.length()==0) return 0;

        int x = 0;
        int sign = 1;

        if(s.charAt(0)=='+'){
            x = 1;
        }else if(s.charAt(0)=='-'){
            sign = -1;
            x = 1;
        }

        if(x==s.length()) return 0;
        if(!Character.isDigit(s.charAt(x))) return 0;

        int idx = x;
        for(int i=idx;i<s.length();i++){
            if(s.charAt(i)!='0'){
                idx = i;
                break;
            }
            if(idx==s.length()-1) return 0;
        }
        long res = 0;
        for(int i=idx;i<s.length();i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9'){
                break;
            }
            res = res*10 + (s.charAt(i)-'0');
            if(sign==1 && res>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign==-1 && -res<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }

        return (int)(sign*res);
    }
}