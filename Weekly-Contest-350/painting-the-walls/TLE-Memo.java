//https://leetcode.com/problems/painting-the-walls/
class Solution {
    int[][] dp;
    int INF=(int)1e9;
    public int rec(int idx,int rem,int[]cost,int[]time){
        if(rem<=0)return 0;
        if(idx==cost.length)return INF;

        if(dp[idx][rem]!=INF)return dp[idx][rem];

        int hire = cost[idx]+rec(idx+1,rem-time[idx]-1,cost,time);
        int nhire =rec(idx+1,rem,cost,time);

        return dp[idx][rem]=Math.min(hire,nhire);

    }
    public int paintWalls(int[] cost, int[] time) {
        dp =new int[cost.length+1][time.length+1];
        for(int[] r:dp){
            Arrays.fill(r,INF);
        }

        return rec(0,time.length,cost,time);
    }
}
