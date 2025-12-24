//https://leetcode.com/contest/weekly-contest-481/problems/minimum-deletion-cost-to-make-all-characters-equal/
class Solution {
    public long minCost(String s, int[] cost) {
        int n = s.length();

        long[] totalCost = new long[26];
        Arrays.fill(totalCost, -1);

        int nonzero = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int c = cost[i];

            if (totalCost[ch - 'a'] == -1) {
                totalCost[ch - 'a'] = 0;
                nonzero++;
            }
            totalCost[ch - 'a'] += c;
        }

        Arrays.sort(totalCost);

        int i = 0;
        long sum = 0;
        while (nonzero > 1 && i < 26) {
            if (totalCost[i] == -1) {
                i++;
                continue;
            }

            nonzero--;
            sum += totalCost[i];
            i++;
        }

        return sum;
    }
}©leetcode
