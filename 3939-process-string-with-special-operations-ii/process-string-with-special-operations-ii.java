class Solution {
    public char processStr(String s, long k) {
        List<Long> list = new ArrayList<>();
        long length = 0;
        long LIMIT = (long)1e15 + 1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                length++;
            }else if(ch=='*'){
                if(length>=1){
                    length--;
                }
            }
            else if(ch=='#'){
                length = Math.min(LIMIT, length * 2);
            }
            else if(ch=='%'){
                length = length;
            }
            list.add(length);
        }
        if(k>=length) return '.';

        for (int i=s.length()-1;i>=0;i--) {
            char ch = s.charAt(i);

            long after = list.get(i);
            long before = (i == 0) ? 0 : list.get(i - 1);

            if(ch>='a' && ch<='z') {
                if(k==before) {
                    return ch;
                }
            } else if(ch=='#') {
                if(before > 0) {
                    k %= before;
                }
            } else if(ch=='%') {
                k = before - 1 - k;
            } else{ // '*'
                // nothing to do
            }
        }
        return '.';
    }
}