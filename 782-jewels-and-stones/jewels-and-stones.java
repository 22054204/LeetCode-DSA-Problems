class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        return Method1(jewels, stones);
    }
    public int Method1(String jewels, String stones) {
        int count = 0;
        for(int i=0;i<jewels.length();i++){
            for(int j=0;j<stones.length();j++){
                if(jewels.charAt(i)==stones.charAt(j)) count++;
            }
        }
        return count;
    }
    public int Method2(String jewels, String stones) {
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