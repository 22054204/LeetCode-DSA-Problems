class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        if(cost.length==1) return cost[0];
        int minCost = 0;
        int i=cost.length-1;
        int j=i-1;
        while(j>=0){
            int sum = cost[i]+cost[j];
            minCost += sum;
            i-=3;
            j-=3;
            if(i==0) minCost += cost[i];
        }
        return minCost;
    }
}