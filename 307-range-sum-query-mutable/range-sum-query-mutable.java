class NumArray {
    int[] nums;
    int BlockSize;
    int[] Block;
    public NumArray(int[] nums) {
        this.nums = nums;
        BlockSize = (int) Math.sqrt(nums.length);
        Block = new int[(nums.length+BlockSize-1)/BlockSize];
        for(int i=0;i<nums.length;i++){
            Block[i/BlockSize] += nums[i];
        }
    }
    
    public void update(int index, int val) {
        Block[index/BlockSize] += val-nums[index]; 
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        // Case 1 => if left & right in same block
        int startBlock = left/BlockSize;
        int endBlock = right/BlockSize;
        if(startBlock == endBlock){ // same Block
            for(int i=left;i<=right;i++){ // O(Sqrt n);
                sum+=nums[i];
            }
        }else if(startBlock!=endBlock){ // case 2 => Both left and right is in different blocks
            // left - {may be full or partial block} // left to end of this block = left part
            int endOfStartBlock = (startBlock+1)*BlockSize - 1;
            for(int i=left;i<=endOfStartBlock;i++){
                sum+=nums[i];
            }
            // middle {full block, if you have} // (endOfStartBlock+1) to (startOfEndBlock-1)
            for(int i=startBlock+1;i<endBlock;i++){ // O(sqrt n)
                sum+=Block[i]; // O(1) because we already find this before
            }
            // right {may be full or partial block}
            int startOfEndBlock = endBlock*BlockSize;
            for(int i=startOfEndBlock;i<=right;i++){
                sum+=nums[i];
            }
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */