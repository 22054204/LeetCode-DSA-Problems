class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                nums[i] = 1;
            }else{
                nums[i] = -1;
            }
        }
        //System.out.println("nums - "+ Arrays.toString(nums));
        
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i] + nums[i-1];
        }
        //System.out.println("nums - "+ Arrays.toString(nums));
        
        int result = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){

                int sum = 0;
                if(i==0) sum = nums[j];
                else sum = nums[j] - nums[i-1];

                if(sum>0) result++;
            }
        }
        return result;
    }
}