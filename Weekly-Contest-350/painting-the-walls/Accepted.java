//https://leetcode.com/problems/painting-the-walls/
class Solution {
    int[][] dp;
    int INF=(int)1e9;
    public int rec(int idx,int rem,int[]cost,int[]time){
        if(rem<=0)return 0;
        if(idx==cost.length)return INF;

        if(dp[idx][rem]!=-1)return dp[idx][rem];  // Simple change Ealier i was checking the invalid state with the iNF but i forgot INF can also be valid state

        int hire = cost[idx]+rec(idx+1,rem-time[idx]-1,cost,time);
        int nhire =rec(idx+1,rem,cost,time);

        return dp[idx][rem]=Math.min(hire,nhire);

    }
    public int paintWalls(int[] cost, int[] time) {
        dp =new int[cost.length+1][time.length+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }

        return rec(0,time.length,cost,time);
    }
}
