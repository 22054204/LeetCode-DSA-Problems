class Solution {
    public int subtractProductAndSum(int n) {
        return Prod(n)-Sum(n);
    }
    private static int Prod(int n){
        int prod = 1;
        while(n!=0){
            prod*=n%10;
            n/=10;
        }
        return prod;
    }
    private static int Sum(int n){
        int sum = 0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}