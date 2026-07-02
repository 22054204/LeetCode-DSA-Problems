class Solution {
    public int theMaximumAchievableX(int num, int t) {
        int steps = 0;
        while(t!=0){
            num++;
            steps++;
            t--;
        }
        return num+steps;
    }
}