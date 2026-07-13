class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        return Method2(low, high);
    }
    public List<Integer> Method2(int low, int high) {
        List<Integer> list = new ArrayList<>();
        int[] nums = {12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789};
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=low && nums[i]<=high){
                list.add(nums[i]);
            }
        }
        return list;
    }
    public List<Integer> Method1(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        for(int i=low+1;i<high;i++){
            String s = String.valueOf(i);
            for(int j=0;j<s.length()-1;j++){
                if(s.charAt(j)<s.charAt(j+1) && s.charAt(j)+1==s.charAt(j+1)){
                    continue;
                }
                else if(s.charAt(j)>=s.charAt(j+1) && s.charAt(j)+1!=s.charAt(j+1)){
                    s = "";
                    break;
                }
            }
            if(s.length()!=0) result.add(Integer.parseInt(s));
        }
        return result;
    }
}