class Solution {
    public int minimumFlips(int n) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append(Integer.toBinaryString(n));
        int i=0;
        int j=sb.length()-1;
        int ans=0;
        while(i<sb.length()){
            if(sb.charAt(i)==sb.charAt(j)){
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