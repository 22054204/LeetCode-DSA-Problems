class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1) return s;

        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        //System.out.println(Arrays.toString(freq));

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
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

        //help us to find right
        for(int i=left.length()-1;i>=0;i--){
            right.append(left.charAt(i));
        }
        
        // System.out.println(left);
        // System.out.println(middle);
        // System.out.println(right);

        return left.toString()+middle.toString()+right.toString();
    }
}