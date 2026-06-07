class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;
        int st = Math.max(1,n-k);
        int end = n+k;
        for(int i=st; i<=end; i++){
            if((n&i)==0){
                sum+=i;
            }
        }
        return sum;
    }
}