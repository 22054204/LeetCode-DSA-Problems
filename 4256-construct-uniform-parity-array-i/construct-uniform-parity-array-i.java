class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int[] nums2 = new int[n];
        
        boolean allEven = true;
        int oddNum = 0;
        for(int num:nums1){
            if(num%2!=0){
                allEven = false;
                oddNum = num;
                break;
            }
        }
        if(allEven) return true; // true because in array nums2 All Even

        for(int i=0;i<n;i++){
            if(nums1[i]%2!=0){
                nums2[i] = nums1[i];
            }else{
                nums2[i] = nums1[i] - oddNum; // because, {even - odd = odd} (nums1[i] is even and oddNum is odd and after subtract this, they always gives us odd result)
            }
        }
        boolean allOdd = true;
        for(int num:nums2){
            if(num%2==0){
                allOdd = false;
                break;
            }
        }
        if(allOdd) return true; // true because do All Odd
        return false; // false because we are not able to build All Odd or All Even.
    }
}