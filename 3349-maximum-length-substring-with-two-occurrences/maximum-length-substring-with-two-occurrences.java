class Solution {
    public int maximumLengthSubstring(String s) {
        return Method2(s);
    }
    //(more optimized version than previous(Method 1) ... because in this we don't reset the whole freq array).
    public int Method2(String s) { 
        int n = s.length();
        int i=0;
        int j=0;
        int maxLen = 0;
        int[] freq = new int[26];
        while(i<n&&j<n){
            freq[s.charAt(j)-'a']++;
            while(freq[s.charAt(j)-'a']>2){
                freq[s.charAt(i)-'a']--;
                i++;
            }
            j++;
            maxLen = Math.max(j-i, maxLen);
        }
        return maxLen;
    }
    public int Method1(String s) {
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