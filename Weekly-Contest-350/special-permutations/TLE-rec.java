//https://leetcode.com/problems/special-permutations/
class Solution {

    int count=0;

    public void rec(int idx,int prev,int mask,int[]nums){
        
        
       if(nums.length > 1 && idx==nums.length && Integer.bitCount(mask)==nums.length){
           count++;
           return;
       }

        if(idx==nums.length)return;

        for(int i=0;i<nums.length;i++){
            boolean isTaken = (mask & ( 1 << i)) != 0;
            if(isTaken)continue;
            if( prev==-1  ||  (nums[i]%nums[prev]==0 || nums[prev]%nums[i]==0)){
                rec(idx+1,i, mask | (1 << i) , nums);
            }
        }

        return ;
    }
    
    public int specialPerm(int[] nums) {
        rec(0,-1,0,nums);
        return count;
    }
}
