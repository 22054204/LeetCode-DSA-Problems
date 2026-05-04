class Solution {
    public boolean isSubsequence(String s, String t) {
        if(!s.isEmpty() && t.isEmpty()) return false;
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length() && !s.isEmpty() && !t.isEmpty()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
            if(i<s.length() && j==t.length()) return false;
        }
        return true;
    }
}