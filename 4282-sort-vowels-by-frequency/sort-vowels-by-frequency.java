import java.util.*;

class Solution {
    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> firstIndex = new HashMap<>();
        Map<Character, Integer> freq = new HashMap<>();

        // collect + count + first index
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                list.add(ch);

                freq.put(ch, freq.getOrDefault(ch, 0) + 1);

                if (!firstIndex.containsKey(ch)) {
                    firstIndex.put(ch, i);
                }
            }
        }

        // sort
        Collections.sort(list, (a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            }
            return firstIndex.get(a) - firstIndex.get(b);
        });

        // put back
        StringBuilder res = new StringBuilder(s);
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                res.setCharAt(i, list.get(idx++));
            }
        }

        return res.toString();
    }

    private boolean isVowel(char ch) {
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}