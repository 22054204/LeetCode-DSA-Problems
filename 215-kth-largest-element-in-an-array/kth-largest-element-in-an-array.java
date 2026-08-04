class Solution {
    public int findKthLargest(int[] nums, int k) {
        return Method2(nums, k);
    }
    //with Heap
    public int Method2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num:nums){
            minHeap.offer(num);
            if(minHeap.size()>k) minHeap.poll();
        }
        return minHeap.poll();
    }
    // we can also solve this way, but in question they said we need to solve without sorting.
    public int Method1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}