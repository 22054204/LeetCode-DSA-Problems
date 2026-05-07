class Solution {
    public int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        if(arr.length==0) return 0;
        if(arr.length==1) return 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                list.add(arr[i]);
            }
        }
        list.add(arr[arr.length-1]);
        int maxLen = 0;
        int length = 0;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)==list.get(i+1)-1){
                length++;
            }else{
                length = 0;
            }
            maxLen = Math.max(length, maxLen);
        }
        return maxLen+1;
    }
}