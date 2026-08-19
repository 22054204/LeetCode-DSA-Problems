class Solution {
    int count = 0;
    private void check(Set<Integer> set){
        boolean A = !set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5);
        boolean B = !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7);
        boolean C = !set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9);

        if(A && C){
            count += 2;
        }else if(A || B || C){
            count += 1;
        }
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<reservedSeats.length;i++){
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];
            if(map.containsKey(row)){
                map.get(row).add(seat);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(seat);
                map.put(row,set);
            }
        }
        for(Set<Integer> values:map.values()){
            check(values);
        }
        return count + (n-map.size())*2;
    }
}