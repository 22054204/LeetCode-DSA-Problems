class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int i=0;
        int j=0;
        int[] nums = {0,0,0};
        while(i<s.length() && j<s.length()){
            if(s.charAt(j)=='a') nums[0]++;
            else if(s.charAt(j)=='b') nums[1]++;
            else nums[2]++;

            while(nums[0]>0 && nums[1]>0 && nums[2]>0){
                ans+=s.length()-j;
                nums[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}