class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) { // 3, 5, 9, 19, 21
        Arrays.sort(asteroids);
        long MASS = mass;
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>MASS) return false;
            MASS += asteroids[i];
        }
        return true;
    }
}