class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int[] nums2 = new int[n];
        
        boolean allEven = true;
        for(int num:nums1){
            if(num%2!=0){
                allEven = false;
                break;
            }
        }
        if(allEven) return true; // true because in array nums2 All Even

        boolean allOdd = true;
        for(int num:nums1){
            if(num%2==0){
                allOdd = false;
                break;
            }
        }
        if(allOdd) return true; // true because in array nums2 All Odd
        
        int i=0;
        int min = nums1[0];
        for(int num:nums1){
            min = Math.min(num, min);
        }
        while(i<n){
            if(nums1[i]%2!=0){
                nums2[i] = nums1[i];
            }else{
                if(nums1[i]-min>=1){
                    nums2[i] = nums1[i]-min;
                }else{
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}