class Solution {
    public int smallestNumber(int n, int t) {
        while(n<=100){
            if(prod(n)%t==0) return n;
            n++;
        }
        return -1;
    }
    public static int prod(int num){
        int prod = 1;
        while(num>0){
            prod*=num%10;
            num/=10;
        }
        return prod;
    }
}