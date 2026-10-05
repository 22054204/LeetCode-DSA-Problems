class Solution {
    public String convertDateToBinary(String date) {
        return new StringBuilder().append(Integer.toBinaryString(Integer.parseInt(date.substring(0, 4)))).append('-').append(Integer.toBinaryString(Integer.parseInt(date.substring(5, 7)))).append('-').append(Integer.toBinaryString(Integer.parseInt(date.substring(8, 10)))).toString();
    }
}