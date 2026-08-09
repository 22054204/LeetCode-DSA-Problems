class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int p;
        int d;
        double fp = 0.0; //fp = final prices
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i=prices.length-1;
        int j=discounts.length-1;
        while(i>=0 && j>=0){
            p = prices[i];
            d = discounts[j];
            fp+=(double)(p*(100-d))/100;
            i--;
            j--;
        }
        while(i>=0){
            fp+=prices[i];
            i--;
        }
        return fp;
    }
}