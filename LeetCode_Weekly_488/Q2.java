class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> ans =new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            if(ans.size()==0 || ans.get(ans.size()-1)!=nums[i]){
                ans.add((long)nums[i]);
            }else{
                long result=nums[i];
                while(ans.size()>0 && ans.get(ans.size()-1)==result){
                    
                    ans.remove(ans.size()-1);
                    result=2*result;
                }
                ans.add(result);
            }

            

            
            
        }

        return ans;
    }
}
