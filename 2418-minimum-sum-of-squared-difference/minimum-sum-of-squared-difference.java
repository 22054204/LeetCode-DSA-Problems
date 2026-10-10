class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int k = k1 + k2;
        int[] arr = new int[100000+1];
        for(int i=0;i<nums1.length;i++){
            arr[Math.abs(nums1[i]-nums2[i])]++;
        }
        for(int i=100000;i>0 && k>0;i--){
            int countOps = Math.min(arr[i], k);
            arr[i-1] += countOps;
            arr[i] -= countOps;
            k -= countOps;
        }
        long res = 0;
        for(int i=0;i<100001;i++){
            long sq = (long)i*i;
            res += sq*arr[i];
        }
        return res;


        /* TLE
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<nums1.length;i++){
            pq.offer(Math.abs(nums1[i]-nums2[i]));
        }   
        //System.out.println(pq);
        long k = (long)k1+k2;
        while(k>0){
            int max = pq.remove(); 
            if(max == 0) break;
            pq.offer(max-1);
            k--;
        }
        //System.out.println(pq);
        long sum = 0;
        while(!pq.isEmpty()){
            long num = pq.remove();
            sum+= num*num;
        }
        return sum;
        */
    }
}