class Solution {
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
    public int sol(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        for(int i=1;i<=2*n;i++){
            if(i%2==0){
                sumEven = sumEven + i;
            }
            else{
                sumOdd = sumOdd + i;
            }
        }
        return gcd(sumOdd, sumEven);
    }
    public static int gcd(int first, int second){
        if(second==0){
            return first;
        }
        return gcd(second, first%second);
    }
}