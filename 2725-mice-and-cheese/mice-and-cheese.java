class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int[] diff = new int[reward1.length];
        int sum = 0;
        for(int i=0; i<reward1.length; i++){
            sum += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        int i = diff.length-1;
        while(i>=0 && k!=0){
            sum += diff[i];
            i--;
            k--;
        }
        return sum;
    }
}