class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
        int prod = 1;
        while(n>0){
            sum+=n%10;
            prod*=n%10;
            n/=10;
        }
        return num%(sum+prod)==0;
    }
}