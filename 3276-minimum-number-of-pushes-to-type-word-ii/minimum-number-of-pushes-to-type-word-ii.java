class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        freq = reverse(freq);
        int count = 0;
        for(int i=0;i<freq.length;i++){
            count+=freq[i]*((i>=0 && i<=7)?1:(i>=8 && i<=15)?2:(i>=16 && i<=23)?3:4);
        }
        return count;
    }
    private static int[] reverse(int[] nums){
        int i=0,j=nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }
}