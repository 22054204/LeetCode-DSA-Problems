class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>mass) return false;
            else if(mass>=Math.pow(10, 5)) return true;
            mass += asteroids[i];
        }
        return true;
    }
}