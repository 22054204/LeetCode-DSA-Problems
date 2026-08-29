class Solution {
    String res;
    char midChar = '!';
    int halfLength = 0;
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int oddCount = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 == 1){
                oddCount++;
                midChar = (char)('a' + i);
            }
        }
        if(oddCount>1) return "";

        // half the frequencies to make just left half of string

        for(int i = 0; i < 26; i++){
            freq[i] /= 2;
        }
        halfLength = s.length()/2;
        String curr = ""; //left half string
        solve(curr, freq, target, 0, false);
        return (res==null)?"":res;
    }
    private boolean solve(String curr, int[] freq, String target, int i, boolean greater){
        if(curr.length()==halfLength){
            String left = curr;
            String right = reverse(curr);

            if(midChar!='!'){
                left+=midChar;
            }
            left+=right;

            if(left.compareTo(target)>0){
                res=left;
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
    private String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}