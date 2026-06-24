class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=0;i<n;i++){
            if(isValid(i) && isValid(n-i)){
                return new int[]{i, n-i};
            }
        }
        return new int[]{};
    }
    private static boolean isValid(int num){
        if(num==0) return false;
        while(num>0){
            if(num%10==0) return false;
            else num = num/10;
        }
        return true;
    }
}