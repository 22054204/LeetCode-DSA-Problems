class Solution {
    public int gcdOfOddEvenSums(int num) {
        return Method4(num);
    }
    public int Method4(int num) {
        return num;
    }
    public int Method3(int n) {
        int odd = n*n;
        int even = n*(n+1);
        return n;
    }
    public int Method2(int n) {
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
    public int Method1(int num) {
        int n = num+num;
        int sum = (n*(n+1))/2;
        int b = (sum+num)/2;
        int a = sum-b;
        return gcd(a, b);
    }
    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}