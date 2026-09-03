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
        
        Arrays.sort(nums1);
        int i=0;
        int j=0;
        while(j<n){
            if(nums1[j]%2==0) j++;
            else break;
        }
        while(i<n){
            if(nums1[i]%2!=0){
                nums2[i] = nums1[i];
            }else{
                if(nums1[i]-nums1[j]>=1){
                    nums2[i] = nums1[i]-nums1[j];
                }else{
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}