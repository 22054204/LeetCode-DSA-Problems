class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1) return 1;
        int[] freq = new int[52];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z') freq[s.charAt(i)-'a']++;
            else freq[s.charAt(i)-'A'+26]++;
        }
        //System.out.println(Arrays.toString(freq));
        int length = 0;
        boolean odd = false;
        for(int i=0;i<freq.length;i++){
            if(freq[i]%2==0){
                length+=freq[i];
            }
            else{
                odd = true;
                length+=freq[i]-1;
            }
        }
        if(odd) length++;
        return length;
    }
}