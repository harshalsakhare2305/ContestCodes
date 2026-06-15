//https://leetcode.com/problems/find-the-value-of-the-partition/
class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        int mini=(int)1e9;
        for(int i=1;i<n;i++){
            mini=Math.min(mini,Math.abs(nums[i]-nums[i-1]));
        }

        return mini;
    }
}
