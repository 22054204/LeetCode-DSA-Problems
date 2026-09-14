class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int a = Math.max(rec1[0], rec2[0]);
        int b = Math.min(rec1[2], rec2[2]);
        int c = Math.max(rec1[1], rec2[1]);
        int d = Math.min(rec1[3], rec2[3]);
        return b-a>0 && d-c>0;
    }
}