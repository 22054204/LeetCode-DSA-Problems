class Solution {
    public int gcdOfOddEvenSums(int num) {
        int n = num+num;
        int sum = (n*(n+1))/2;
        int b = (sum+num)/2;
        int a = sum-b;
        return gcd(a, b);
    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}