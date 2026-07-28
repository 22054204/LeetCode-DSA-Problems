class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1) return s;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        StringBuilder left = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        // help us to find left and middle
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                if(freq[i]/2!=0){
                    for(int j=0;j<freq[i]/2;j++){
                        left.append((char)(i+'a'));
                    }
                }
                if(freq[i]%2==1){
                    middle.append((char)(i+97));
                }
            }
        }
        return left.toString()+middle.toString()+left.reverse().toString();
    }
}