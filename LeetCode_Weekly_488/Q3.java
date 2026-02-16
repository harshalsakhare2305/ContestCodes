class Solution {
    public long countSubarrays(int[] nums, long k) {

        int n = nums.length;
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        long count = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {

           
            while (!max.isEmpty() && nums[max.peekLast()] < nums[r]) {
                max.pollLast();
            }
            max.offerLast(r);

            
            while (!min.isEmpty() && nums[min.peekLast()] > nums[r]) {
                min.pollLast();
            }
            min.offerLast(r);

        
            while ((long)(nums[max.peekFirst()] - nums[min.peekFirst()]) * (r - l + 1) > k) {

                if (max.peekFirst() == l) max.pollFirst();
                if (min.peekFirst() == l) min.pollFirst();
                l++;
            }

            count += (r - l + 1);
        }

        return count;
    }
}
