class Solution {
    public int maxFrequencyElements(int[] nums) {
        Arrays.sort(nums); //[1,1,2,2,3,4]
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }else{
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        int sum = list.get(list.size()-1);
        System.out.println(sum);
        int num = 0;
        for(int i=list.size()-2;i>=0;i--){
            if(sum == list.get(i)){
                num = num + list.get(i);
            }
        }
        sum = sum + num;
        return sum;
    }
}