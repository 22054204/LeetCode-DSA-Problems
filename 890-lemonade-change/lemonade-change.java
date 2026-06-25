class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0]!=5) return false;
        int change = 0;
        int fiveDollar = 0;
        int tenDollar = 0;
        int twentyDollar = 0;
        for(int i=0;i<bills.length;i++){
            change = bills[i]-5;

            // if customer gave 5$ bill then change = 0
            if(change == 0) fiveDollar++;

            // if customer gave 10$ bill then change = 5
            else if(change==5){
                if(fiveDollar==0) return false;
                fiveDollar--;
                tenDollar++;
            }

            // if customer gave 20$ bill then change = 15
            else{
                if(tenDollar >= 1 && fiveDollar >= 1){
                    tenDollar--;
                    fiveDollar--;
                }
                else if(fiveDollar >= 3){
                    fiveDollar -= 3;
                }
                else{
                    return false;
                }
                twentyDollar++;
            }
        }
        return true;
    }
}