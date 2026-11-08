class Solution {
    public int countServers(int[][] grid) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            list.clear();
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    list.add(i+","+j);
                }
            }
            if(list.size()>1){
                for(String arr:list){
                    set.add(arr);
                }
            }
        }
        for(int i=0;i<n;i++){
            list.clear();
            for(int j=0;j<m;j++){
                if(grid[j][i]==1){
                    list.add(j+","+i);
                }
            }
            if(list.size()>1){
                for(String arr:list){
                    set.add(arr);
                }
            }
        }
        return set.size();

    }
}