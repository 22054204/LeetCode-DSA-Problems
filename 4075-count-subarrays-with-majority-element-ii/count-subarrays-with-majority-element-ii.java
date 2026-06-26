class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        return Method5(nums, target);
    }
    public long Method5(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int cummSum = 0;
        long validLeftPoints = 0;
        long result = 0;

        for(int i=0;i<nums.length;i++) {
            if (nums[i] == target) {
                validLeftPoints += map.getOrDefault(cummSum, 0);
                cummSum += 1;
            }else{
                cummSum -= 1;
                validLeftPoints -= map.getOrDefault(cummSum, 0);
            }
            map.put(cummSum, map.getOrDefault(cummSum, 0) + 1);
            result += validLeftPoints;
        }
        return result;
    }
    //by using cummulative sum 
    public int Method4(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                nums[i] = 1;
            }else{
                nums[i] = -1;
            }
        }
        //System.out.println("nums - "+ Arrays.toString(nums));
        
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i] + nums[i-1];
        }
        //System.out.println("nums - "+ Arrays.toString(nums));
        
        int result = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){

                int sum = 0;
                if(i==0) sum = nums[j];
                else sum = nums[j] - nums[i-1];

                if(sum>0) result++;
            }
        }
        return result;
    }
    
    // improved BruteForce
    public int Method3(int[] nums, int target) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int freq = 0;
            for(int j=i;j<nums.length;j++){
                if (nums[j] == target) freq++;
                int len = j - i + 1;
                if (freq > len / 2) count++;
            }
        }
        return count;
    }

    // without generating all subarrays, but not works because O(n^3)
    public int Method2(int[] nums, int target) {
        int result = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int count = 0;
                for(int k=i;k<=j;k++){
                    if(nums[k]==target) count++;
                }
                int size = j-i+1;
                if(count>size/2){
                    result++;
                }
            }
        }
        return result;
    }

    // Brute Force - TLE for given constraints; suitable only for small arrays.
    public int Method1(int[] nums, int target) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                List<Integer> list = new ArrayList<>();
                for(int k=i;k<=j;k++){
                    list.add(nums[k]);
                }
                if(isValid(list, target)) count++;
            }
        }
        return count;
    }
    private static boolean isValid(List<Integer> list, int target){
        int freq = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==target){
                freq++;
            }
        }
        return freq>list.size()/2;
    }
}