class Solution {
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int maxEle = maxEle(nums);
        int[][][] t = new int[n+1][maxEle+1][maxEle+1];  
        for(int first=0;first<=maxEle;first++){
            for(int second = 0;second<=maxEle;second++){
                t[n][first][second] = (first!=0 && second!=0 && first==second) ? 1 : 0;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int first=maxEle; first>=0;first--){
                for(int second=maxEle; second>=0;second--){
                    int skip = t[i+1][first][second];
                    int take1 = t[i+1][gcd(first, nums[i])][second];
                    int take2 = t[i+1][first][gcd(second, nums[i])];

                    t[i][first][second] = (int)(((long)skip + (long)take1 + (long)take2) % 1000000007);
                }
            }
        }
        return t[0][0][0];
    }
    private static int maxEle(int[] nums){
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
    private static int gcd(int a, int b){
        return (b==0) ? a : gcd(b, a%b);
    }
}