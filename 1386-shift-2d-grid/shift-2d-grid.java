class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                list.add(grid[i][j]);
            }
        }
        list = helper(list, k);
        for (int i=0;i<list.size();i+=n) {
            int end = Math.min(list.size(), i+n);
            result.add(list.subList(i, end));
        }
        return result;
    }
    private static List<Integer> helper(List<Integer> list, int k){
        int n = list.size();
        k = k%n;
        rotate(list, 0, n-1);
        rotate(list, 0, k-1);
        rotate(list, k, n-1);
        return list;
    }
    private static void rotate(List<Integer> list, int i, int j){
        while(i<j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
        i++;
        j--;
        }
    }
}