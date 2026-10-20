class Solution {
    public int sortableIntegers(int[] nums) {
        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);

        int ans = 0;
        int n = nums.length;
        for(int k=1;k<=n;k++){
            if(n%k!=0) continue;
            // check k is sortable or not ??
            boolean validK = true;
            for(int start=0;start<n;start+=k){
                int[] arr1 = new int[k];  // from nums
                int[] arr2 = new int[k];  // from sortedArray
                for(int i=0;i<k;i++){
                    arr1[i] = nums[start+i];
                }
                for(int i=0;i<k;i++){
                    arr2[i] = sortedArray[start+i];
                }
                if(!isContains(arr1, arr2)){
                    validK = false;
                    break;
                } 
            }
            if(validK) ans+=k;
        }
        return ans;
    }
    // for checking we are Using KMP 
    public boolean isContains(int[] arr1, int[] arr2) {
        if (arr2.length == 0) return true;
        if (arr2.length > arr1.length * 2) return false;
        int virtualLength = arr1.length * 2;
        int[] lps = computeLPSTable(arr2);
        int i=0;
        int j=0;
        while (i < virtualLength) {
            if (arr1[i % arr1.length] == arr2[j]) {
                i++;
                j++;
            }
            if (j == arr2.length) {
                return true; 
            } else if (i < virtualLength && arr1[i % arr1.length] != arr2[j]) {
                if (j != 0) {
                    j = lps[j - 1]; 
                } else {
                    i++;
                }
            }
        }
        return false;
    }
    private int[] computeLPSTable(int[] arr2) {
        int[] lps = new int[arr2.length];
        int len = 0;
        int i = 1;
        
        while (i < arr2.length) {
            if (arr2[i] == arr2[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}