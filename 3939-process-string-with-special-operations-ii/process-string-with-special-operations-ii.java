class Solution {
    public char processStr(String s, long k) {
        long length = 0;
        long LIMIT = (long)1e15 + 1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                length++;
            }else if(ch=='*'){
                if(length>0){
                    length--;
                }
            }
            else if(ch=='#'){
                length = Math.min(LIMIT, length * 2);
            }
            else if(ch=='%'){
                length = length;
            }
        }
        if(k>=length) return '.';
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);

            if(ch>='a' && ch<='z'){
                length--;
            }else if(ch=='*'){
                length++;
            }
            else if(ch=='#'){
                length/=2;
                if(k>=length){
                    k -= length;
                }
            }
            else if(ch=='%'){
                length = length;
                k = length-k-1;
            }
            if(length==k) return ch;
        }
        return '.';
    }
}