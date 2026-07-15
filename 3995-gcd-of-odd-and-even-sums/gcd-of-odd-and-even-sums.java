class Solution {
    public int gcdOfOddEvenSums(int num) {
        int sum = ((num+num)*((num+num)+1))/2;
        return gcd((sum+num)/2, sum-((sum+num)/2));
    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}