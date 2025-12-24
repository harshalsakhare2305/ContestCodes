//https://leetcode.com/problems/total-sum-of-interaction-cost-in-tree-groups/description/
import java.util.*;

class Solution {
    private long totalCost = 0;
    private int[][] counts;
    private int[] totalInGroup;
    private List<Integer>[] adj;

    public long interactionCosts(int n, int[][] edges, int[] group) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        totalInGroup = new int[21];
        for (int g : group) totalInGroup[g]++;

        counts = new int[n][21]; // we keep count of nodes in subtree rooted at u whose group is same
        dfs(0, -1, group);

        return totalCost;
    }

    private void dfs(int u, int p, int[] group) {
        counts[u][group[u]] = 1; // u belong to group of group[u] making it count

        for (int v : adj[u]) {
            if (v == p) continue;
            
            dfs(v, u, group); // going into depths
            
            for (int g = 1; g <= 20; g++) {
                if (totalInGroup[g] < 2) continue; // single element belong to group so no pair as u!=v
                
                long inSubtree = counts[v][g];  // in count
                long outsideSubtree = totalInGroup[g] - inSubtree;  //outcount=total-incount
                
                totalCost += inSubtree * outsideSubtree;
                counts[u][g] += counts[v][g];   
            }
        }
    }
}
