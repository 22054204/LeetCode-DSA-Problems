class Solution {
    public boolean checkInclusion(String s, String t) {
        return Better(s, t);
    }
    public static boolean Better(String s, String t){
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        s = sort(s);
        
        int length = s.length();
        
        for (int i = 0; i <= t.length() - length; i++) {
            String x = t.substring(i, i + length);
            x = sort(x);
            if(x.equals(s)){
                return true;
            }
        }
        return false;
    }
    private static String sort(String s){
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        s = new String(arr1);
        return s;
    }
    public boolean BruteForce(String s, String t) {
        char[] arr = s.toCharArray();
        return generate(arr, t, 0);
    }
    private static boolean generate(char[] arr, String t, int start){
        if(start == arr.length){
            return t.contains(new String(arr));
        }

        for(int i=start;i<arr.length;i++){
            swap(arr, i, start);
            if(generate(arr, t, start+1)) return true;
            swap(arr, i, start);
        }
        return false;
    }
    private static void swap(char[] nums, int first, int second){
        char temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}