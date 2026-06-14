//https://leetcode.com/problems/minimum-operations-to-make-median-of-array-equal-to-k/
class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int mid = n / 2;

        long ans = 0;

        if (nums[mid] < k) {

            for (int i = mid; i < n; i++) {
                if (nums[i] < k) {
                    ans += (long) k - nums[i];
                }
            }

        } else {

            for (int i = 0; i <= mid; i++) {
                if (nums[i] > k) {
                    ans += (long) nums[i] - k;
                }
            }

        }

        return ans;
    }
}
