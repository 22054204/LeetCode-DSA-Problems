class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        if(temperatures.length==1) return new int[]{0};
        int n = temperatures.length;
        int[] answer = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()) answer[i] = 0;
            else answer[i] =  stack.peek()-i;
            stack.push(i);
        }
        return answer;
    }
}