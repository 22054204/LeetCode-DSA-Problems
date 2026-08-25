class Solution {
    public int missingMultiple(int[] nums, int k) {
        int[] arr = new int[102];
        for(int i=0;i<=101;i++){
            arr[i] = k*i;
        }
        Arrays.sort(nums);
        int i=0,j=1;
        while(i<nums.length){
            if(i!=0 && nums[i]==nums[i-1]){
                i++;
            }
            else if(nums[i]%k!=0){
                i++;
            }else if(nums[i]%k==0){
                if(nums[i]==arr[j]){
                    i++;
                    j++;
                }else{
                    return arr[j];
                }
            }
        }
        return arr[j];
    }
}