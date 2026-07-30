class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        int n = s.length();
        for(int i=0;i<s.length();i++){
            if(n%2==1 && i==n/2) continue;  
            freq[s.charAt(i)-'a']++;
        }
        String mid = "";
        if(n%2==1) mid += s.charAt(n/2);

        // for just left's freq, divide every freq array of chars divide by 2
        for(int i=0;i<freq.length;i++){
            freq[i] = freq[i]/2;
        }
        StringBuilder left = new StringBuilder();
        int half = n/2;
        for(int i=0;i<half;i++){
            boolean placedCharacter = false;
            for(int j=0;j<freq.length;j++){
                if(freq[j]>0){
                    freq[j]-=1;

                    //count number of ways
                    long ways = 1;
                    int letters = 0;
                    for(int c=0;c<26;c++){
                        if(freq[c]!=0){
                            letters += freq[c];
                        }
                    }

                    for(int c=0;c<26;c++){
                        if(freq[c]>0){
                            ways *= nCr(letters, freq[c], k);
                            letters -= freq[c];
                        }
                        if(ways>=k) break;
                    }
                    if(ways>=k){ // this block contains my Kth value
                        left.append((char)(j+'a'));
                        placedCharacter = true;
                        break;
                    }
                    k -= ways; // when K >= ways, the skip this block and move to build next block
                    freq[j] += 1;
                }
            }
            if(placedCharacter==false) return "";
        }
        StringBuilder right = new StringBuilder(left);
        right.reverse();
        return left.toString()+mid+right.toString();
    }
    private static long nCr(int n, int r, int k){
        r = Math.min(r, n-r);
        long result = 1;
        for(int i=1;i<=r;i++){
            result = result*(n-r+i)/i;
            if(result>=k) return k;
        }
        return result;
    }
}































