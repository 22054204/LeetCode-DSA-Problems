class Solution {
    public int myAtoi(String s) {
        return Optimal(s);
    }
    public int Optimal(String s) {
        if(s.length()==0) return 0;

        s = s.trim();
        if(s.length()==0) return 0;

        StringBuilder sb = new StringBuilder();

        int x = 0;
        int sign = 1;

        if(s.charAt(0)=='+'){
            x = 1;
        }else if(s.charAt(0)=='-'){
            sign = -1;
            sb.append(s.charAt(0));
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
            if(i==s.length()-1) return 0;
        }

        for(int i=idx;i<s.length();i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9'){
                break;
            }
            sb.append(s.charAt(i));
        }

        String abc = sb.toString();

        if(abc.length()==0 || abc.equals("-")) return 0;

        try{
            long res = Long.parseLong(abc);

            if(res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(res<Integer.MIN_VALUE) return Integer.MIN_VALUE;

            return (int)res;
        }catch(Exception e){
            if(sign==-1) return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }
    public int BruteForce(String s) {
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