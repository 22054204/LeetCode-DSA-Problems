class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = findMax(nums);
        int[] freq = new int[max+1];
        for(int i=0;i<nums.length;i++){
            for(int j=1;j*j<=nums[i];j++){
                if(nums[i]%j==0){
                    freq[j]++;
                    if(nums[i]/j!=j){
                        freq[nums[i]/j]++;
                    } 
                }
            }
        }
        long[] pairsWithGcd = new long[max+1];
        for(int i=max;i>=1;i--){
            long count = freq[i]; 
            pairsWithGcd[i] = count*(count-1)/2;
            //correction time
            for(int mul=2*i;mul<=max;mul+=i){
                pairsWithGcd[i] -= pairsWithGcd[mul];
            }
        }
        long[] prefixCountGcd = new long[max+1];
        for(int i=1;i<=max;i++){
            prefixCountGcd[i] = prefixCountGcd[i-1] + pairsWithGcd[i];
        }

        int[] result = new int[queries.length];
        int i = 0;
        for(long idx:queries){
            int st = 1;
            int end = max;
            int temp = 1;
            while(st<=end){
                int mid = st+(end-st)/2;
                if(prefixCountGcd[mid]>idx){
                    temp = mid;
                    end = mid-1;
                }else{
                    st = mid+1;
                }
            }
            result[i++] = temp;
        }
        return result;
    }
    private static int findMax(int[] nums){
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}