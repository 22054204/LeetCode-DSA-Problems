class Solution {
    public boolean rotateString(String s, String goal) {
        return Optimal(s, goal);
    }
    public boolean Optimal(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String temp = s+s;
        if(temp.contains(goal)) return true;
        return false;
    }
    public boolean BruteForce(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        if(s.equals(goal)) return true;
        return helper(s, goal);
    }
    private static boolean helper(String s, String goal){
        int n = s.length();
        for(int k = 1;k<=n;k++){
            char[] arr1 = s.toCharArray();
            char[] arr2 = goal.toCharArray();
            rotate(arr1, 0, n-1);
            rotate(arr1, 0, k-1);
            rotate(arr1, k, n-1);
            if(Arrays.equals(arr1, arr2)) return true;
        }
        return false;
    }
    private static void rotate(char[] arr1, int i, int j){
        while(i<j){
            char temp = arr1[i];
            arr1[i] = arr1[j];
            arr1[j] = temp;
            i++;
            j--;
        }
    }
}