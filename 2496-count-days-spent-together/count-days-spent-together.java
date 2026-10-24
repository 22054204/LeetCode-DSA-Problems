class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Alice
        int arive_day_Alice = Integer.parseInt(arriveAlice.substring(3, 5));
        int arive_month_Alice = Integer.parseInt(arriveAlice.substring(0, 2));
        int leave_day_Alice = Integer.parseInt(leaveAlice.substring(3, 5));
        int leave_month_Alice = Integer.parseInt(leaveAlice.substring(0, 2));

        // Bob
        int arive_day_Bob = Integer.parseInt(arriveBob.substring(3, 5));
        int arive_month_Bob = Integer.parseInt(arriveBob.substring(0, 2));
        int leave_day_Bob = Integer.parseInt(leaveBob.substring(3, 5));
        int leave_month_Bob = Integer.parseInt(leaveBob.substring(0, 2));

        int aliceAriveDay = arive_day_Alice;
        int i=0;
        while(i < arive_month_Alice-1){
            aliceAriveDay += days[i++];
        }

        int aliceLeaveDay = leave_day_Alice;
        i=0;
        while(i < leave_month_Alice - 1){
            aliceLeaveDay += days[i++];
        }

        int BobAriveDay = arive_day_Bob;
        i=0;
        while(i < arive_month_Bob - 1){
            BobAriveDay += days[i++];
        }

        int BobLeaveDay = leave_day_Bob;
        i=0;
        while(i < leave_month_Bob - 1){
            BobLeaveDay += days[i++];
        }
        int start = Math.max(aliceAriveDay, BobAriveDay);
        int end = Math.min(aliceLeaveDay, BobLeaveDay);

        return Math.max(0, end - start + 1);
    }
}