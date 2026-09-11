class Solution {
    int n = 0;
    public int totalNumbers(int[] digits) {
        n = digits.length;
        boolean allOdd = true;
        for(int num:digits){
            if(num%2==0) allOdd = false;
        }
        if(allOdd) return 0; // because if all are odd digits in array, then there is no possile way to make any even digit from that.

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(digits[i], map.getOrDefault(digits[i], 0)+1);
        }

        Arrays.sort(digits);
        int firstMin = digits[0];
        int secondMin = digits[1];
        int thirdMin = digits[2];

        int k = 0;
        while(k<n && digits[k]==0){ // using this for skipping leading zeros
            k++;
        }
        if(k==n) return 0;

        if(k==0){
            firstMin = digits[0];
            secondMin = digits[1];
            thirdMin = digits[2];
        }
        else if(k==1){
            firstMin = digits[1];
            secondMin = digits[0];
            thirdMin = digits[2];
        }
        else{
            firstMin = digits[k];
            secondMin = digits[0];
            thirdMin = digits[1];
        }

        int minPossibleNumMadeFromArray = 0;

        if(firstMin==0 && secondMin==0 && thirdMin==0) return 0; // because in this condition all ele are zeros; 
        else if(firstMin==0 && secondMin==0 && thirdMin!=0){
            minPossibleNumMadeFromArray = thirdMin*100;
        }
        else if(firstMin==0 && secondMin!=0 && thirdMin!=0){
            minPossibleNumMadeFromArray = (((secondMin*10)+firstMin)*10)+thirdMin;
        }else{ // all non zero
            minPossibleNumMadeFromArray = (((firstMin*10)+secondMin)*10)+thirdMin;
        }
        
        int firstMax = digits[n-1];
        int secondMax = digits[n-2];
        int thirdMax = digits[n-3];
        
        int maxPossibleNumMadeFromArray = (((firstMax*10)+secondMax)*10)+thirdMax;

        if(minPossibleNumMadeFromArray == maxPossibleNumMadeFromArray){
            if(minPossibleNumMadeFromArray%2==0) return 1;
            else return 0;
        }

        int result = 0;
        for(int i=minPossibleNumMadeFromArray;i<=maxPossibleNumMadeFromArray;i++){
            if(i%2==0){
                int fDig = i%10;
                int sDig = (i%100)/10;
                int tDig = (i%1000)/100;

                // Check and consume first digit
                if(map.containsKey(fDig) && map.get(fDig)>0){
                    map.put(fDig, map.get(fDig)-1);
                    // Check and consume second digit
                    if(map.containsKey(sDig) && map.get(sDig)>0){
                        map.put(sDig, map.get(sDig)-1);
                        // Check and consume third digit
                        if(map.containsKey(tDig) && map.get(tDig)>0){
                            map.put(tDig, map.get(tDig)-1);
                            result++;
                            // Restore third digit
                            map.put(tDig, map.get(tDig)+1);
                        }
                        // Restore second digit
                        map.put(sDig, map.get(sDig)+1);
                    }
                    // Restore first digit
                    map.put(fDig, map.get(fDig)+1);
                }
            }
        }
        return result;
    }
}