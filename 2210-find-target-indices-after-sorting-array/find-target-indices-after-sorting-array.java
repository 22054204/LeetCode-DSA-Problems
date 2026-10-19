class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int numLessThanTarget = 0;
        int numEqualsToTarget = 0;
        for(int num:nums){
            if(num<target) numLessThanTarget++;
            else if(num==target) numEqualsToTarget++;
        }
        for(int i=0;i<numEqualsToTarget;i++){
            result.add(numLessThanTarget+i);
        }
        return result;
    }
}