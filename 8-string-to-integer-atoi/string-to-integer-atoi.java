class Solution {
    public int myAtoi(String s) {
        if(s.length()==0) return 0;

        s = s.trim(); // white space remove
        if(s.length()==0) return 0;

        StringBuilder sb = new StringBuilder();

        int x = 0;
        if(s.charAt(0)=='+'){
            x = 1;
        }else if(s.charAt(0)=='-'){
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
            if(sb.charAt(0)=='-') return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }
}