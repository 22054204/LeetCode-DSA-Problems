class Solution {
    public int sumCounts(List<Integer> list) {
        int n = list.size();
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                HashSet<Integer> set = new HashSet<>();
                for(int k=i;k<=j;k++){
                    set.add(list.get(k));
                }
                int uniq = set.size();
                res += uniq * uniq;
            }
        }
        return res;
    }
}