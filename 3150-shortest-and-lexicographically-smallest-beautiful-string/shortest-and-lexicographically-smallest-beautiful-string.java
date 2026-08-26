class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        String result = "";

        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                count++;
            }

            // We have exactly k ones
            if (count == k) {

                // Remove unnecessary 0s from the left
                while (s.charAt(left) == '0') {
                    left++;
                }

                // Current window
                String temp = s.substring(left, right + 1);

                // Compare with answer
                if (result.equals("") || temp.length() < result.length()) {
                    result = temp;
                }else if (temp.length() == result.length() && temp.compareTo(result) < 0){
                    result = temp;
                }

                // Move left past the first 1
                left++;
                count--;
            }
        }
        return result;
    }
}