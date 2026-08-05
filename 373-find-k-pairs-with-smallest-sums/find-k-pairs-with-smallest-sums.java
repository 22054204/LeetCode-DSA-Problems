class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> MaxHeap = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int sum = nums1[i]+nums2[j];
                int[] arr = {0,0,0};//[sum, nums1[i], nums2[j]];
                arr[0] = sum;
                arr[1] = nums1[i];
                arr[2] = nums2[j];
                if(MaxHeap.size()<k){
                    MaxHeap.offer(arr);
                }else if(sum<MaxHeap.peek()[0]){
                    MaxHeap.poll();
                    MaxHeap.offer(arr);
                }else{
                    break;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!MaxHeap.isEmpty()){
            int[] pair = MaxHeap.poll();
            List<Integer> list = new ArrayList<>();
            list.add(pair[1]);
            list.add(pair[2]);
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}