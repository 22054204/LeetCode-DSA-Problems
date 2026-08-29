class Solution {
    String res;
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        String curr = "";
        solve(curr, freq, target, 0, false);
        return (res==null)?"":res;
    }
    private boolean solve(String curr, int[] freq, String target, int i, boolean greater){
        if(i==target.length()){
            if(greater){
                res=curr;
                return true;
            }
            return false;
        }

        for(char ch='a';ch<='z';ch++){
            if(freq[ch-'a']==0) continue;
            if(greater==false && ch<target.charAt(i)) continue;
            curr+=ch;
            freq[ch-'a']--;

            boolean isgreater = ch>target.charAt(i) || greater;
            if(solve(curr, freq, target, i+1, isgreater)) return true;
            curr = curr.substring(0, curr.length() - 1);
            freq[ch-'a']++;
        }
        return false;
    }
}