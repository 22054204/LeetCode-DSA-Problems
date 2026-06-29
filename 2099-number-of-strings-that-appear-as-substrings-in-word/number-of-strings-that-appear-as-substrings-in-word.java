class Solution {
    public int numOfStrings(String[] patterns, String word) {
        return Method1(patterns, word);
    }
    public int Method1(String[] patterns, String word) {
        int ans = 0;
        for(int i=0;i<patterns.length;i++){
            if(word.contains(patterns[i])) ans++;
        }
        return ans;
    }
    // without using inbuild function
    /*
    private int Method2(String[] patterns, String word) {
        int ans = 0;
        for(int i=0;i<patterns.length;i++){
            if(helper(patterns[i], word)) ans++;
        }
        return ans;
    }
    private boolean helper(String pat, String word) {
        for (int i=0;i<=word.length()-pat.length();i++) {
            int j = 0;
            while (j<pat.length() && word.charAt(i+j)==pat.charAt(j)) {
                j++;
            }
            if (j==pat.length()) return true;
        }
        return false;
    }
    */
}