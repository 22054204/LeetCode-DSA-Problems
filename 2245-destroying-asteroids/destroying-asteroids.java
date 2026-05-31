class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) { // 3, 5, 9, 19, 21
        return Method2(mass, asteroids);
    }
    public boolean Method1(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long MASS = mass;
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>MASS) return false;
            MASS += asteroids[i];
        }
        return true;
    }
    //Method-2
    public boolean Method2(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>mass) return false;
            else if(mass>=1e5) return true;
            mass += asteroids[i];
        }
        return true;
    }
}