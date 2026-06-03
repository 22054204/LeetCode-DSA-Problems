class Solution {
    public int smallestEvenMultiple(int n) {
        if(n==1) return 2;
        for(int i=1;i<=n*n;i++){
            if(i%2==0 && i%n==0){
                return i;
            }
        }
        return -1;
    }
}