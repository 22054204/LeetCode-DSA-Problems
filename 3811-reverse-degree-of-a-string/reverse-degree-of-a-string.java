class Solution {
    public int reverseDegree(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(122-i, i+1);
        }
        int ans = 0;
        for(int i=0;i<s.length();i++){
            ans+=(i+1)*map.get((int)s.charAt(i));
        }
        return ans;
    }
}