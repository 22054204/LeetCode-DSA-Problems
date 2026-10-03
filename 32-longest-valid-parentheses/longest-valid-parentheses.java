class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        for(int i=0;i<s.length();i++){
            int count = 0;
            if(s.charAt(i)=='(') left++;
            else if(s.charAt(i)==')') right++;
            if(left==right){
                count = left+right;
                maxCount = Math.max(maxCount, count);
            }else if(right>left){
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for(int i=s.length()-1;i>=0;i--){
            int count = 0;
            if(s.charAt(i)=='(') left++;
            else if(s.charAt(i)==')') right++;
            if(left==right){
                count = left+right;
                maxCount = Math.max(maxCount, count);
            }else if(left>right){
                left = 0;
                right = 0;
            }
        }
        return maxCount;
    }
}