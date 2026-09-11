class Solution {
    int n = 0;
    public int totalNumbers(int[] digits) {
        n = digits.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(digits[i], map.getOrDefault(digits[i], 0)+1);
        }
        int result = 0;
        for(int i=1;i<=9;i++){ // first digit cannot be 0
            if(!map.containsKey(i)) continue;
            map.put(i, map.get(i)-1);
            for(int j=0;j<=9;j++){
                if(!map.containsKey(j) || map.get(j)==0) continue;
                map.put(j, map.get(j)-1);
                for(int k=0;k<=8;k+=2){ // last digit must be even
                    if(!map.containsKey(k) || map.get(k)==0) continue;
                    result++;
                }
                map.put(j, map.get(j)+1);
            }
            map.put(i, map.get(i)+1);
        }
        return result;
    }
}