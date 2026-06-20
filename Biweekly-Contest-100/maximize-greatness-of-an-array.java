class Solution {
    public int maximizeGreatness(int[] nums) {
        PriorityQueue<Integer> pq =new PriorityQueue<>();

      

        int n=nums.length;
        Arrays.sort(nums);

          for(int ele:nums){
            pq.add(ele);
        }

        int count=0;
        int idx=0;

        while(!pq.isEmpty()){

            while(!pq.isEmpty() && pq.peek()<=nums[idx]){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                idx++;
                count++;
            }
        }

        return count;
    }
}©leetcode
