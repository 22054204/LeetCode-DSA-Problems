class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        for(char ch = 'a'; ch <= 'z'; ch++){
            int lower = word.lastIndexOf(ch);
            int upper = word.indexOf(Character.toUpperCase(ch));
            if(lower != -1 && upper != -1 && lower < upper)
                count++;
        }
        return count;
    }
}