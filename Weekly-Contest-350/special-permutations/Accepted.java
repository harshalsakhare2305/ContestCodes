class Solution {

    long[][][] dp;
    int MOD = 1_000_000_007;

    long rec(int idx, int prev, int mask, int[] nums) {

        if (mask == (1 << nums.length) - 1)
            return 1;

        if (dp[idx][prev + 1][mask] != -1)
            return dp[idx][prev + 1][mask];

        long ans = 0;

        for (int i = 0; i < nums.length; i++) {

            if ((mask & (1 << i)) != 0)
                continue;

            if (prev == -1 ||
                nums[i] % nums[prev] == 0 ||
                nums[prev] % nums[i] == 0) {

                ans += rec(idx + 1, i,
                           mask | (1 << i),
                           nums);

                ans %= MOD;
            }
        }

        return dp[idx][prev + 1][mask] = ans;
    }

    public int specialPerm(int[] nums) {

        int n = nums.length;

        dp = new long[n + 1][n + 1][1 << n];

        for (long[][] a : dp)
            for (long[] b : a)
                Arrays.fill(b, -1);

        return (int) rec(0, -1, 0, nums);
    }
}
