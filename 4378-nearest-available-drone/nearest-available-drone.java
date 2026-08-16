class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int n = drones.length;
        int[] manhattan = new int[drones.length];
        int idx = 0;
        for(int i=0;i<n;i++){
            int x_drone = drones[i][0];
            int y_drone = drones[i][1];
            int range_drone = drones[i][2];
            int x_targ = target[0];
            int y_targ = target[1];

            //manhattan distance
            int dist = Math.abs(x_drone-x_targ)+Math.abs(y_drone-y_targ);
            if(dist>range_drone){
                manhattan[idx++] = -26; // if not in range
            }else{
                manhattan[idx++] = dist; // in range
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<manhattan.length;i++){
            if(manhattan[i]==-26) continue;
            if(min>manhattan[i]){
                min = manhattan[i];
            }
        }
        int ans = 0;
        for(int i=0;i<manhattan.length;i++){
            if(manhattan[i]==min){
                return i;
            }
        }
        return -1;
    }
}