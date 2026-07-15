class Solution {
    public int gcdOfOddEvenSums(int num) {
        int sum = ((num+num)*((num+num)+1))/2;
        int a = (sum+num)/2;
        return gcd(a, sum-a);
    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}