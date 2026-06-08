class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];

        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                result[k++] = nums[i];
            }
        }
        int pivCount = checkCount(nums, pivot);
        while(pivCount!=0){
            result[k++] = pivot;
            pivCount--;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>pivot){
                result[k++] = nums[i];
            }
        }
        return result;
    }
    private static int checkCount(int[] nums, int pivot){
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot){
                count++;
            }
        }
        return count;
    }
}