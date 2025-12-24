//https://leetcode.com/contest/weekly-contest-481/problems/minimum-swaps-to-avoid-forbidden-values/description/

class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        HashMap<Integer,Integer> numMap =new HashMap<>();
        HashMap<Integer,Integer> FMap =new HashMap<>();
        HashMap<Integer,Integer> badMap =new HashMap<>();

        int n =nums.length;

        int ct=0;

        for(int i=0;i<n;i++){
            numMap.put(nums[i],numMap.getOrDefault(nums[i],0)+1);
             FMap.put(forbidden[i],FMap.getOrDefault(forbidden[i],0)+1);

            if(nums[i]==forbidden[i]){
                ct++;
                 badMap.put(forbidden[i],badMap.getOrDefault(forbidden[i],0)+1);
            }
        }

    for(int i=0;i<n;i++){
        int ctnum=numMap.get(nums[i]);
        int ctf=0;

        if(FMap.containsKey(nums[i])){
             ctf=FMap.get(nums[i]);
        }
       
        if(ctnum+ctf>n){
            return -1;
        }
    }
   int maxi=0;
    for(int key:badMap.keySet()){
        maxi=Math.max(maxi,badMap.get(key));
    }

        return Math.max(maxi,(ct+1)/2);
        
        
    }
}
