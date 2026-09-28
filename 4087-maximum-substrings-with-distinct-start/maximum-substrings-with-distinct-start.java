class Solution {
    public int maxDistinct(String s) {
        boolean[] seen = new boolean[26];
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(!seen[s.charAt(i)-'a']){
                seen[s.charAt(i)-'a'] = true;
                count++;
            }
        }
        return count;
    }
}