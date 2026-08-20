class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int i=2;
        int idx1 = 1;
        int idx2 = 1;
        while(i<nums.length){
            if(arr1[idx1-1]>arr2[idx2-1]){
                arr1[idx1++] = nums[i++];
            }else{
                arr2[idx2++] = nums[i++];
            }
        }

        int idx = 0;
        for(i=0;i<arr1.length;i++){
            if(arr1[i]!=0) nums[idx++] = arr1[i];
        }

        for(int j=0;j<arr2.length;j++){
            if(arr2[j]!=0) nums[idx++] = arr2[j];
        }
        return nums;
    }
}