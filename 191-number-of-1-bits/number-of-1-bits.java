class Solution {
    public int hammingWeight(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(n, 2));
        int count = 0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}