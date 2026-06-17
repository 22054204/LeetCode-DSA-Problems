class Solution {
    public char processStr(String s, long k) {
        long length = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char ch = arr[i];
            if(ch>='a' && ch<='z'){
                length++;
            }else if(ch=='*'){
                if(length>0){
                    length--;
                }
            }
            else if(ch=='#'){
                length *= 2;
            }
            else if(ch=='%'){
                length = length;
            }
        }
        if(k>=length) return '.';
        for(int i=arr.length-1;i>=0;i--){
            char ch = arr[i];

            if(ch>='a' && ch<='z'){
                length--;
            }else if(ch=='*'){
                length++;
            }
            else if(ch=='#'){
                length /= 2;
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