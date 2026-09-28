class Solution {
    public int maxDepth(String s) {
        int maxNestingDepth = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') count++;
            if(s.charAt(i)==')') count--;
            maxNestingDepth = Math.max(maxNestingDepth, count);
        }
        return maxNestingDepth;
    }
}