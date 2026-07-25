class Solution {
    public int maxProduct(int num) {
        int max = 0;
        int secMax = 0;
        while(num>0){
            int rem = num%10;
            if(rem>max){
                secMax = max;
                max = rem;
            }else if(rem>secMax){
                secMax = rem;
            }
            num /= 10; 
        }
        return max*secMax;
    }
}