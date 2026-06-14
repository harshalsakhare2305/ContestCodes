//https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int[] inc =new int[n];
        int[] dec =new int[n];

        int maxi=0;

        for(int i=0;i<n;i++){
            if(i==0){
                inc[i]=1;
                dec[i]=1;
            }else{

                if(nums[i-1]<nums[i]){
                    inc[i]=inc[i-1]+1;
                    dec[i]=1;
                }else if(nums[i-1]>nums[i]){
                    dec[i]=dec[i-1]+1;
                    inc[i]=1;
                }else{
                    inc[i]=1;
                    dec[i]=1;
                }
                
            }

            maxi=Math.max(maxi,Math.max(inc[i],dec[i]));
        }

        return maxi;
    }
}
