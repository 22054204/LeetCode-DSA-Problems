class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if(nums.length==1){
            list.add(nums[0]);
            return list;
        }
        if(nums.length==2){
            list.add(nums[0]);
            list.add(nums[1]);
            return list;
        }

        boolean[] valid = new boolean[nums.length];

        start(nums, valid);  // left check
        end(nums, valid);    // right check

        for(int i=0;i<nums.length;i++){
            if(valid[i]){
                list.add(nums[i]);
            }
        }

        return list;
    }

    public static void start(int[] nums, boolean[] valid){
        int max = nums[0];
        valid[0] = true;

        for(int i=1;i<nums.length;i++){
            if(nums[i] > max){
                valid[i] = true;
            }
            max = Math.max(max, nums[i]);
        }
    }

    public static void end(int[] nums, boolean[] valid){
        int max = nums[nums.length-1];
        valid[nums.length-1] = true;

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] > max){
                valid[i] = true;
            }
            max = Math.max(max, nums[i]);
        }
    }
}