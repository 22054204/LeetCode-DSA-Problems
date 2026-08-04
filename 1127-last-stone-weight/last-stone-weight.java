class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        List<Integer> list = new ArrayList<>();
        for(int num:stones){
            list.add(num);
        }
        Collections.sort(list);
        while(list.size()>1){
            int y = list.get(list.size()-1);
            int x = list.get(list.size()-2);
            list.remove(list.size()-1);
            list.remove(list.size()-1);
            int z = Math.abs(y-x);
            if(z!=0) list.add(z);
            Collections.sort(list);
        }
        return list.isEmpty() ? 0 : list.get(0);
    }
}