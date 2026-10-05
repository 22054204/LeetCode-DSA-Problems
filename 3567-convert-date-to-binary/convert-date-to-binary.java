class Solution {
    public String convertDateToBinary(String date) {
        StringBuilder result = new StringBuilder();
        result.append(Integer.toBinaryString(Integer.parseInt(date.substring(0, 4))));
        result.append('-');
        result.append(Integer.toBinaryString(Integer.parseInt(date.substring(5, 7))));
        result.append('-');
        result.append(Integer.toBinaryString(Integer.parseInt(date.substring(8, 10))));
        return result.toString();
    }
}