 Key Observation

Alice and Bob must remove a contiguous subarray [ 𝑙 , 𝑟 ] [l,r].

They can repeat this up to 𝑛 − 1 n−1 times, leaving exactly one element in the end.

In one move, they cannot remove both the first and last element together because:

Removing a contiguous subarray always leaves either the prefix or suffix of the array.

🔍 What does this imply?

After every deletion:

Either the first element of the original array survives, or

The last element of the original array survives.

👉 It is impossible to eliminate both the first and last elements.

So, the final remaining element must be one of these two:

nums[0]

nums[n-1]

🏆 Optimal Strategy

Since both players play optimally:

The best achievable final value is simply the maximum of the first and last elements.

💡 Final Solution class Solution { public int finalElement(int[] nums) { return Math.max(nums[0], nums[nums.length - 1]); } } ⏱ Complexity

Time: O(1)

Space: O(1)

✨ One-line Conclusion

Because a contiguous deletion can never remove both ends, the final element must be either the first or the last — so the answer is max(nums[0], nums[n−1]).
