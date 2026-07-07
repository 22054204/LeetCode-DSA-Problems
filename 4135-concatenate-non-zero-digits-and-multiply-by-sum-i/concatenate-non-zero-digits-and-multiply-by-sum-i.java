class Solution {
    public long sumAndMultiply(int n) {
        int rev = 0;
        long sum = 0;
        while(n>0){
            if(n%10==0) n/=10;
            else{
                rev = (rev*10) + (n%10);
                sum += rev%10;
                n /= 10;
            }
        }
        int revToSt = 0;
        while(rev>0){
            revToSt = (revToSt*10) + (rev%10);
            rev /= 10;
        }
        return (long)revToSt*sum;
    }
}




















