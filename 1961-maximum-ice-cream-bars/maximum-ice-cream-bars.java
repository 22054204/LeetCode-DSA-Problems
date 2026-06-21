class Solution {
    public int maxIceCream(int[] costs, int coins) {
        return Method1(costs, coins);
    }
    public int Method1(int[] costs, int coins) {
        int[] freq = new int[100001];
        for(int i=0;i<costs.length;i++) {
            freq[costs[i]]++;
        }
        int count = 0;
        for(int cost = 1; cost <= 100000; cost++) {
            while(freq[cost] > 0 && coins >= cost) {
                coins -= cost;
                count++;
                freq[cost]--;
            }
        }
        return count;
    }
    public int Method2(int[] costs, int coins) {
        costs = countSort(costs);
        int sum = 0;
        int count = 0;
        for(int i=0;i<costs.length;i++){
            sum+=costs[i];
            if(sum>coins){
                break;
            }
            count++;
        }
        return count;
    }
    private static int[] countSort(int[] costs){
        int max = findMax(costs);
        int[] arr = new int[max+1];
        for(int i=0;i<costs.length;i++){
            arr[costs[i]]++;
        }
        int k = 0;
        for(int i=0;i<arr.length;i++){
            while(arr[i]>0){
                costs[k++] = i;
                arr[i]--;
            }
        }
        return costs;
    }
    private static int findMax(int[] costs){
        int max = 1;
        for(int i=0;i<costs.length;i++){
            max = Math.max(max, costs[i]);
        }
        return max;
    }

    public int Method3(int[] costs, int coins) {
        Arrays.sort(costs); // 2,3,3,5,6,6,6,7,9,10
        int sum = 0;
        int count = 0;
        for(int i=0;i<costs.length;i++){
            sum+=costs[i];
            if(sum>coins){
                break;
            }
            count++;
        }
        return count;
    }
}