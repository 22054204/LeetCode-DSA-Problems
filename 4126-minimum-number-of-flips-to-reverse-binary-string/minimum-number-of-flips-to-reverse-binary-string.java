class Solution {
    public int minimumFlips(int n) {
        String s = "";
        s = s+Integer.toBinaryString(n);
        int i=0;
        int j=s.length()-1;
        int ans=0;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                ans+=2;
                i++;
                j--;
            }
        }
        return ans;
    }
}