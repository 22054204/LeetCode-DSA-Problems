class Solution {
    public int minimumFlips(int n) {
        String s = "";
        s = s+Integer.toBinaryString(n);
        int i=0;
        int j=s.length()-1;
        int ans=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                ans++;
                i++;
                j--;
            }
        }
        return ans;
    }
}