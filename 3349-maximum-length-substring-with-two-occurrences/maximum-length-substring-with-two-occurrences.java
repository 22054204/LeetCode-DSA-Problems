class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int i=0;
        int j=0;
        int maxLen = 0;
        int[] freq = new int[26];
        while(i<n&&j<n){
            while(j<n){
                freq[s.charAt(j)-'a']++;
                if(freq[s.charAt(j)-'a']>2) break;
                else j++;
            }
            maxLen = Math.max(j-i, maxLen);
            i++;
            j=i;
            Arrays.fill(freq, 0);
        }
        return maxLen;
    }
}