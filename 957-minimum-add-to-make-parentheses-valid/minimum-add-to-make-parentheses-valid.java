class Solution {
    public int minAddToMakeValid(String s) {
        int open_count = 0;
        int close_count = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                open_count++;
            }
            else if(ch==')' && open_count>0){
                open_count--;
            }else{
                close_count++;
            }
        }
        return open_count+close_count;
    }
}