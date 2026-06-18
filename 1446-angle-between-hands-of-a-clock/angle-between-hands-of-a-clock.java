class Solution {
    public double angleClock(int hour, int minutes) {
        return Method1(hour, minutes);
    }
    public double Method2(int hour, int minutes) {
        double angle1 = Math.abs((30)*(hour) - (5.5)*(minutes));
        double angle2 = 360-angle1;
        double result = Math.min(angle1, angle2);
        return result;
    }
    public double Method1(int hour, int minutes) {
        double angle1 = Math.abs((30)*(hour) - (5.5)*(minutes));
        if(angle1<=180) return angle1;
        return 360-angle1;
    }
}