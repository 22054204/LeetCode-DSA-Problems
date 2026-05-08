class Solution {
    public int minimumFlips(int n) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append(Integer.toBinaryString(n));
        sb2.append(Integer.toBinaryString(n));
        System.out.println(sb);
        sb2.reverse();
        System.out.println(sb2);
        int i=0;
        int j=0;
        int ans=0;
        while(i<sb.length() && j<sb2.length()){
            if(sb.charAt(i)==sb2.charAt(j)){
                i++;
                j++;
            }else{
                ans++;
                i++;
                j++;
            }
        }
        return ans;
    }
}