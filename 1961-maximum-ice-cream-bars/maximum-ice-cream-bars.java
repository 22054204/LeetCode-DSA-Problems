class Solution {
    public int maxIceCream(int[] costs, int coins) {
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