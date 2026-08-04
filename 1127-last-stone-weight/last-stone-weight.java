class Solution {
    public int lastStoneWeight(int[] stones) {
        return WithHeap(stones);
    }
    public int WithHeap(int[] stones) { //maxHeap requires to smashing the two heaviest stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            maxHeap.offer(stones[i]);
        }
        while(maxHeap.size()>1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            int z =  y-x;
            if(z!=0) maxHeap.offer(z);
        }
        return maxHeap.isEmpty()?0:maxHeap.poll();
    }
    public int WithoutUsingHeapDataStructures(int[] stones) {
        if(stones.length==1) return stones[0];
        List<Integer> list = new ArrayList<>();
        for(int num:stones){
            list.add(num);
        }
        Collections.sort(list);
        while(list.size()>1){
            int y = list.remove(list.size()-1);
            int x = list.remove(list.size()-1);
            int z = y-x;
            if(z!=0) list.add(z);
            Collections.sort(list);
        }
        return list.isEmpty()?0:list.get(0);
    }
}