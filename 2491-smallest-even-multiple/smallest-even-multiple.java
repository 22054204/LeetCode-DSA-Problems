class Solution {
    public int smallestEvenMultiple(int n){
        return Method2(n);
    }
    public int Method2(int n) {
        for(int i=1;i<=n*n;i++){
            if(i%2==0 && i%n==0){
                return i;
            }
        }
        return n*2;
    }
    public int Method1(int n) {
        if(n%2==0){
            return n;
        }
        return n*2;
    }
}