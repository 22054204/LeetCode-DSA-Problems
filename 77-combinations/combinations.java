class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        build(1, n, k, list, result);
        return result;
    }

    private void build(int start, int n, int k, List<Integer> list, List<List<Integer>> result) {

        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i); 
            build(i+1, n, k, list, result);
            list.remove(list.size() - 1);
        }
    }
}