class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        String s = "";
        for(int i=0;i<chunks.length;i++){
            s += chunks[i];
        }
        int n = queries.length;

        s = s.replaceAll("[^a-z-]", " ");
        s = s.replaceAll("--+", " ");
        s = s.replaceAll("(^-|-$)", " ");
        s = s.replaceAll("- ", " ");
        s = s.replaceAll(" -", " ");

        String[] arr = s.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].length() == 0) continue;
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            if(map.containsKey(queries[i])){
                result[i] = map.get(queries[i]);
            }
            else result[i] = 0;
        }
        return result;
    }
}