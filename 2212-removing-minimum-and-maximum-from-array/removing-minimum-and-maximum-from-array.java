class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        if(n==2) return 2;

        int min = nums[0];
        int max = nums[0];

        int minIdx = 0;
        int maxIdx = 0;

        for(int i=1;i<n;i++){
            if(min>nums[i]){
                min = nums[i];
                minIdx = i;
            }
            if(max<nums[i]){
                max = nums[i];
                maxIdx = i;
            }
        }

        boolean leftSideForMin = false;
        boolean rightSideForMin = false;

        boolean leftSideForMax = false;
        boolean rightSideForMax = false;

        int a = Math.min(n-minIdx, minIdx+1); //min
        if(a==n-minIdx) rightSideForMin = true;
        else leftSideForMin = true;

        int b = Math.min(n-maxIdx, maxIdx+1); //max
        if(b==n-maxIdx) rightSideForMax = true;
        else leftSideForMax = true;

        int c = 0;
        if((leftSideForMin && rightSideForMax) || (leftSideForMax && rightSideForMin)){
            c=a+b;
        }
        else if((leftSideForMin && leftSideForMax) || (rightSideForMin && rightSideForMax)){
            c=Math.max(a, b);
        }
        boolean minOccur = false;
        boolean maxOccur = false;

        int i=0;
        int leftLen = 1;
        while(minOccur==false || maxOccur==false){
            if(nums[i]==min) minOccur = true;
            if(nums[i]==max) maxOccur = true;
            if(minOccur && maxOccur) break;
            else leftLen++;
            i++;
        }

        minOccur = false;
        maxOccur = false;

        i=n-1;
        int rightLen = 1;
        while(minOccur==false || maxOccur==false){
            if(nums[i]==min) minOccur = true;
            if(nums[i]==max) maxOccur = true;
            if(minOccur && maxOccur) break;
            else rightLen++;
            i--;
        }
        int len = Math.min(leftLen, rightLen);
        return Math.min(len, c);
    }
}