//Method 1 
class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
    }
    public int sumRange(int left, int right) {
        return (left==0)?prefix[right]:prefix[right]-prefix[left-1];
    }
}

/* Method 2 -> 
    But slows than above solution because in this, we need to find out sum from scratch always (i.e from left to right)... but in above solution we firstly build Prefix Array and then for each query we got it's SUM in Constant Complexity O(1).

    class NumArray {
        int[] arr;
        public NumArray(int[] nums) {
            arr = nums.clone();
        }
        public int sumRange(int left, int right) {
            int sum = 0;
            for(int i=left;i<=right;i++){
                sum+=arr[i];
            }
            return sum;
        }
    }

*/ 



/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */