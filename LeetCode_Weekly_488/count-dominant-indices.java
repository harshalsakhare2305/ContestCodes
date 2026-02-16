//https://leetcode.com/problems/count-dominant-indices/
class Solution {
    public int dominantIndices(int[] nums) {
        int n=nums.length;
        int[] suffix =new int[n];
        suffix[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
        }

        int count=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]>(suffix[i+1]/(n-i-1))){
                count++;
            }
        }

        return count;
    }
}
