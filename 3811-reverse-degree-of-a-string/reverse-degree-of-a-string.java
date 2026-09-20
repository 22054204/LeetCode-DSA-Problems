class Solution {
    public int reverseDegree(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put((char)(122-i), i+1);
        }
        int ans = 0;
        for(int i=0;i<s.length();i++){
            ans+=(i+1)*map.get(s.charAt(i));
        }
        return ans;
    }
}