class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
        }

         boolean[] marked =new boolean[n];

    long score=0;

    while(!pq.isEmpty()){

        int[] smallest = pq.poll();
        int idx=smallest[1];

        score+=smallest[0];
        marked[idx]=true;
        if(idx-1>=0){
            marked[idx-1]=true;
        }

        if(idx+1<n){
            marked[idx+1]=true;
        }


        while(!pq.isEmpty() && marked[pq.peek()[1]]){
            pq.poll();
        }
        
    }

    return score;
    }

   
}
©leetcode
