class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];
        for(int i=0;i<n;i++){
            if(isValid(i) && isValid(n-i)){
                result[0] = i;
                result[1] = n-i;
            }
        }
        return result;
    }
    private static boolean isValid(int num){
        while(num>0){
            if(num%10==0) return false;
            else num = num/10;
        }
        return true;
    }
}