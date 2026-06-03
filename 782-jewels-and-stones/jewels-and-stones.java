class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        int i=0;
        int j=0;
        while(i<jewels.length()){
            if(jewels.charAt(i)==stones.charAt(j)){
                count++;
            }
            if(j==stones.length()-1){
                i++;
                j=-1;
            }
            j++;
        }
        return count;
    }
}